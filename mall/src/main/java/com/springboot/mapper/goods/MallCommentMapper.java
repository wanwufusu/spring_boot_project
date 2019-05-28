package com.springboot.mapper.goods;

import com.springboot.bean.goods.MallComment;

public interface MallCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallComment record);

    int insertSelective(MallComment record);

    MallComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallComment record);

    int updateByPrimaryKey(MallComment record);
}