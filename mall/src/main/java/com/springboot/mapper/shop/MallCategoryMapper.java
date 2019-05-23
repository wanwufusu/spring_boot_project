package com.springboot.mapper.shop;

import com.springboot.bean.shop.CategoryName;
import com.springboot.bean.shop.MallCategory;

import java.util.List;

public interface MallCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallCategory record);

    int insertSelective(MallCategory record);

    MallCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallCategory record);

    int updateByPrimaryKey(MallCategory record);

    List<MallCategory> selectAllCategorys();

    List<CategoryName> selectL1Categorys();
}