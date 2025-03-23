package com.controller;


import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.YonghuEntity;
import com.service.YonghuService;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import com.utils.StringUtil;
import com.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.entity.RenwuOneEntity;
import com.service.RenwuOneService;
import com.entity.view.RenwuOneView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 任务管理
 * 后端接口
 * @author
 * @email
 * @date
*/
@RestController
@Controller
@RequestMapping("/renwuOne")
public class RenwuOneController {
    private static final Logger logger = LoggerFactory.getLogger(RenwuOneController.class);

    @Autowired
    private RenwuOneService renwuOneService;

    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("jieshouyonghuId",request.getSession().getAttribute("userId"));
        }else if(StringUtil.isNotEmpty(role) && "经理".equals(role)){
            params.put("fabuyonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = renwuOneService.queryPage(params);

        //字典表数据转换
        List<RenwuOneView> list =(List<RenwuOneView>)page.getList();
        for(RenwuOneView c:list){
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
        RenwuOneEntity renwuOne = renwuOneService.selectById(id);
        if(renwuOne !=null){
            //entity转view
            RenwuOneView view = new RenwuOneView();
            BeanUtils.copyProperties( renwuOne , view );//把实体数据重构到view中

            //查询发布用户信息
            YonghuEntity fabuyonghu = yonghuService.selectById(renwuOne.getFabuyonghuId());
            if(fabuyonghu != null){
                view.setFabuname(fabuyonghu.getName());
                view.setFabuphone(fabuyonghu.getPhone());
                view.setFabuidNumber(fabuyonghu.getIdNumber());
            }
            //查询接收用户信息
            YonghuEntity jieshouyonghu = yonghuService.selectById(renwuOne.getJieshouyonghuId());
            if(jieshouyonghu != null){
                view.setJieshouname(jieshouyonghu.getName());
                view.setJieshouname(jieshouyonghu.getPhone());
                view.setJieshouidNumber(jieshouyonghu.getIdNumber());
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
    public R save(@RequestBody RenwuOneEntity renwuOne, HttpServletRequest request){
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            return R.error("您没有权限新增任务");
        }else if("经理".equals(role)){
            String userId = String.valueOf(request.getSession().getAttribute("userId"));
            renwuOne.setFabuyonghuId(Integer.valueOf(userId));
        }else{
            return R.error("您没有权限新增任务1");
        }
        Date date = new Date();
        renwuOne.setInsertTime(date);
        renwuOne.setCreateTime(date);
        renwuOne.setChakanTypes(2);//设置为未查看
        renwuOneService.insert(renwuOne);
        return R.ok();
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RenwuOneEntity renwuOne, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,renwuOne:{}",this.getClass().getName(),renwuOne.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            renwuOne.setChakanTypes(1);//设置为已查看
        }else{
            return R.error("您没有修改任务是否查看过的权限");
        }
        renwuOneService.updateById(renwuOne);//根据id更新
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        renwuOneService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

