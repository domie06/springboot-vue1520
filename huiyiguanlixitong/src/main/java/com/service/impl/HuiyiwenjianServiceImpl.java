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

import com.dao.HuiyiwenjianDao;
import com.entity.HuiyiwenjianEntity;
import com.service.HuiyiwenjianService;
import com.entity.view.HuiyiwenjianView;

/**
 * 会议文件管理 服务实现类
 * @author 
 * @since 2021-03-16
 */
@Service("huiyiwenjianService")
@Transactional
public class HuiyiwenjianServiceImpl extends ServiceImpl<HuiyiwenjianDao, HuiyiwenjianEntity> implements HuiyiwenjianService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<HuiyiwenjianView> page =new Query<HuiyiwenjianView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
