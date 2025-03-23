package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.HuiyiwenjianEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.HuiyiEntity;

import com.entity.view.HuiyiView;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 会议管理
 * 后端接口
 * @author
 * @email
 * @date 2021-03-16
*/
@RestController
@Controller
@RequestMapping("/huiyi")
public class HuiyiController {
    private static final Logger logger = LoggerFactory.getLogger(HuiyiController.class);

    @Autowired
    private HuiyiService huiyiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private HuiyiwenjianService huiyiwenjianService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        PageUtils page = huiyiService.queryPage(params);
        //字典表数据转换
        List<HuiyiView> list =(List<HuiyiView>)page.getList();
        for(HuiyiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuiyiEntity huiyi = huiyiService.selectById(id);
        if(huiyi !=null){
            //entity转view
            HuiyiView view = new HuiyiView();
            BeanUtils.copyProperties( huiyi , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(huiyi.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HuiyiEntity huiyi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huiyi:{}",this.getClass().getName(),huiyi.toString());
        Wrapper<HuiyiEntity> queryWrapper = new EntityWrapper<HuiyiEntity>()
            .eq("huiyishi_types", huiyi.getHuiyishiTypes())
            .eq("huiyi_name", huiyi.getHuiyiName())
            .eq("huiyi_types", huiyi.getHuiyiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuiyiEntity huiyiEntity = huiyiService.selectOne(queryWrapper);
        if(huiyiEntity==null){
            huiyi.setCreateTime(new Date());
            String role = String.valueOf(request.getSession().getAttribute("role"));
            String userId = String.valueOf(request.getSession().getAttribute("userId"));
            if("经理".equals(role)){
                huiyi.setHuiyiTypes(2);
            }else if("用户".equals(role)){
                huiyi.setHuiyiTypes(4);
            }else{
                return R.error("未知异常,请联系管理员");
            }
            huiyi.setYonghuId(Integer.valueOf(userId));
            huiyiService.insert(huiyi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuiyiEntity huiyi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huiyi:{}",this.getClass().getName(),huiyi.toString());
        if("管理员".equals(String.valueOf(request.getSession().getAttribute("role")))){
            huiyiService.updateById(huiyi);//根据id更新
            return R.ok();
        }else{
            return R.error("您没有权限修改会议");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<HuiyiEntity> list = huiyiService.selectList(new EntityWrapper<HuiyiEntity>().in("id", ids));
        huiyiService.deleteBatchIds(Arrays.asList(ids));
        List<Integer> huiyiIds = new ArrayList<>();
        for(HuiyiEntity h:list){
            huiyiIds.add(h.getId());
        }
        if(huiyiIds != null && huiyiIds.size()>0){
            huiyiwenjianService.delete(new EntityWrapper<HuiyiwenjianEntity>().in("huiyi_id", huiyiIds));
        }
        return R.ok();
    }


}

