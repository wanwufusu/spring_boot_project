package com.springboot.mapper.shop;

import com.springboot.bean.util.PageDetail;
import com.springboot.bean.shop.MallBrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallBrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallBrand record);

    int insertSelective(MallBrand record);

    MallBrand selectByPrimaryKey(Integer id);

    List<MallBrand>selectByPageDetail(@Param("pageDetail")PageDetail pageDetail);

    int selectAllRecords();

    int updateByPrimaryKeySelective(MallBrand record);

    int updateByPrimaryKey(MallBrand record);
}