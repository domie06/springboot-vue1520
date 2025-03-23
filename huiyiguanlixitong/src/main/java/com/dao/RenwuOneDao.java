package com.dao;

import com.entity.RenwuOneEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.RenwuOneView;

/**
 * 任务管理 Dao 接口
 *
 * @author 
 * @since 2021-03-16
 */
public interface RenwuOneDao extends BaseMapper<RenwuOneEntity> {

   List<RenwuOneView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
