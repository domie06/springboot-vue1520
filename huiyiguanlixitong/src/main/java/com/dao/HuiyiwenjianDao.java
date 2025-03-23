package com.dao;

import com.entity.HuiyiwenjianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuiyiwenjianView;

/**
 * 会议文件管理 Dao 接口
 *
 * @author 
 * @since 2021-03-16
 */
public interface HuiyiwenjianDao extends BaseMapper<HuiyiwenjianEntity> {

   List<HuiyiwenjianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
