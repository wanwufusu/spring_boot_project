package com.springboot.mapper.shop;

import com.springboot.bean.shop.MallOrder;

public interface MallOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallOrder record);

    int insertSelective(MallOrder record);

    MallOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallOrder record);

    int updateByPrimaryKey(MallOrder record);
}