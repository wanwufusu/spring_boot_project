package com.springboot.mapper.goods;

import com.springboot.bean.goods.MallAttribute;

public interface MallAttributeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallAttribute record);

    int insertSelective(MallAttribute record);

    MallAttribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallAttribute record);

    int updateByPrimaryKey(MallAttribute record);
}