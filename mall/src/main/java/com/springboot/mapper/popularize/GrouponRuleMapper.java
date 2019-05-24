package com.springboot.mapper.popularize;

import com.springboot.bean.popularize.MallGrouponRules;
import com.springboot.bean.util.PageDetail;

import java.util.List;

public interface GrouponRuleMapper {

    List findList(PageDetail pageDetail);

    int countList();

    int insert (MallGrouponRules groupon);

    int update(MallGrouponRules groupon);

    int deleteById(int id);
}
