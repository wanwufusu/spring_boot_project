package com.springboot.mapper.goods;

import com.springboot.bean.goods.MallSpecification;

public interface MallSpecificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallSpecification record);

    int insertSelective(MallSpecification record);

    MallSpecification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallSpecification record);

    int updateByPrimaryKey(MallSpecification record);
}