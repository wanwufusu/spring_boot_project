package com.springboot.mapper.shop;

import com.springboot.bean.shop.MallRegion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface MallRegionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallRegion record);

    int insertSelective(MallRegion record);

    MallRegion selectByPrimaryKey(Integer id);

    List<MallRegion> selectAllRegions();

    int updateByPrimaryKeySelective(MallRegion record);

    int updateByPrimaryKey(MallRegion record);
}