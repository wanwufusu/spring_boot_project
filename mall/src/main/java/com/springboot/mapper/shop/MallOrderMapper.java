package com.springboot.mapper.shop;

import com.springboot.bean.shop.MallOrder;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface MallOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallOrder record);

    int insertSelective(MallOrder record);

    MallOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallOrder record);

    int updateByPrimaryKey(MallOrder record);

    List<MallOrder> selectByPageDetailAndConditions(@Param("pageDetail")PageDetail pageDetail,
                                                    @Param("conditions")HashMap<String, Object> conditions);

    int selectAllRecordsByConditions(@Param("conditions")HashMap<String, Object> conditions);
}