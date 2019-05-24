package com.springboot.service.shop.impl;

import com.springboot.bean.shop.MallIssue;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;
import com.springboot.mapper.shop.MallIssueMapper;
import com.springboot.service.shop.ShopIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/24
 * @since 1.0.0
 */
@Service
public class ShopIssueServiceImpl implements ShopIssueService {
    @Autowired
    MallIssueMapper mallIssueMapper;

    @Override
    public Result<MallIssue> selectPageIssueByConditions(PageDetail pageDetail, HashMap<String, Object> conditions) {
        pageDetail.setOffset();
        Result<MallIssue> result = new Result<>();
        result.setItems(mallIssueMapper.selectByPageDetailAndConditions(pageDetail, conditions));
        result.setTotal(mallIssueMapper.selectAllRecordsByConditions(conditions));
        return result;
    }

    @Override
    public int insertIssue(MallIssue mallIssue) {
        return mallIssueMapper.insert(mallIssue);
    }

    @Override
    public void deleteIssueById(Integer id) {
        mallIssueMapper.logicDeleteIssueById(id);
    }

    @Override
    public int update(MallIssue mallIssue) {
        return mallIssueMapper.updateByPrimaryKey(mallIssue);
    }
}
