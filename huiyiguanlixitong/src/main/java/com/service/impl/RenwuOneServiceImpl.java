package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.RenwuOneDao;
import com.entity.RenwuOneEntity;
import com.service.RenwuOneService;
import com.entity.view.RenwuOneView;

/**
 * 任务管理 服务实现类
 * @author 
 * @since 2021-03-16
 */
@Service("renwuOneService")
@Transactional
public class RenwuOneServiceImpl extends ServiceImpl<RenwuOneDao, RenwuOneEntity> implements RenwuOneService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<RenwuOneView> page =new Query<RenwuOneView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
