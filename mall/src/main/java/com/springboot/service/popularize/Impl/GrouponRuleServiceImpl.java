package com.springboot.service.popularize.Impl;


import com.springboot.bean.popularize.MallGrouponRules;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;
import com.springboot.mapper.popularize.GrouponRuleMapper;
import com.springboot.service.popularize.GrouponRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrouponRuleServiceImpl implements GrouponRuleService {
    @Autowired
    GrouponRuleMapper mapper;
    @Override
    public Result findList(PageDetail pageDetail) {
        pageDetail.setOffset();
        List list = mapper.findList(pageDetail);
        return new Result<>(list, mapper.countList());
    }

    @Override
    public MallGrouponRules add(MallGrouponRules groupon) {
        int insert = mapper.insert(groupon);
        if (insert!=0){
            groupon.setId(insert);
            return groupon;
        }else
            return null;
    }
    @Override
    public MallGrouponRules update(MallGrouponRules groupon) {
        int update = mapper.update(groupon);
        if (update!=0){
            groupon.setId(update);
            return groupon;
        }else
            return null;
    }

    @Override
    public int delete(MallGrouponRules groupon) {
        Integer id = groupon.getId();
        return mapper.deleteById(id);
    }
}
