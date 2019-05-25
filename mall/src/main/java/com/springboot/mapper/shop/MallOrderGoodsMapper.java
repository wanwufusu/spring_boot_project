package com.springboot.mapper.shop;

import com.springboot.bean.shop.MallOrderGoods;

import java.util.List;

public interface MallOrderGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallOrderGoods record);

    int insertSelective(MallOrderGoods record);

    MallOrderGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallOrderGoods record);

    int updateByPrimaryKey(MallOrderGoods record);

    List<MallOrderGoods> selectOrderGoods();

}