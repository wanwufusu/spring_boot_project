package com.springboot.mapper.shop;

import com.springboot.bean.shop.MallKeyword;
import com.springboot.bean.util.PageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface MallKeywordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallKeyword record);

    int insertSelective(MallKeyword record);

    MallKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallKeyword record);

    int updateByPrimaryKey(MallKeyword record);

    List<MallKeyword> selectByPageDetailAndConditions(@Param("pageDetail")PageDetail pageDetail,
                                                      @Param("conditions")HashMap<String, Object> conditions);

    int selectAllRecordsByConditions(@Param("conditions")HashMap<String, Object> conditions);

    void logicDeleteKeywordById(Integer id);
}