package com.springboot.service.shop;

import com.springboot.bean.shop.MallIssue;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;

import java.util.HashMap;

public interface ShopIssueService {


    Result<MallIssue> selectPageIssueByConditions(PageDetail pageDetail, HashMap<String, Object> conditions);

    int insertIssue(MallIssue mallIssue);

    void deleteIssueById(Integer id);

    int update(MallIssue mallIssue);
}
