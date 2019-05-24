package com.springboot.mapper.shop;

import com.springboot.bean.shop.MallIssue;
import com.springboot.bean.util.PageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface MallIssueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallIssue record);

    int insertSelective(MallIssue record);

    MallIssue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallIssue record);

    int updateByPrimaryKey(MallIssue record);

    List<MallIssue> selectByPageDetailAndConditions(@Param("pageDetail")PageDetail pageDetail,
                                                    @Param("conditions")HashMap<String, Object> conditions);

    int selectAllRecordsByConditions(@Param("conditions")HashMap<String, Object> conditions);

    void logicDeleteIssueById(Integer id);
}