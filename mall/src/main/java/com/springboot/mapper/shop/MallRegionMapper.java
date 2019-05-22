package com.springboot.mapper.shop;

import com.springboot.bean.shop.MallRegion;

public interface MallRegionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallRegion record);

    int insertSelective(MallRegion record);

    MallRegion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallRegion record);

    int updateByPrimaryKey(MallRegion record);
}