package com.springboot.service.popularize;

import com.springboot.bean.popularize.MallGrouponRules;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;

public interface GrouponRuleService {

    Result findList(PageDetail pageDetail,Integer goodsId);

    MallGrouponRules add(MallGrouponRules ad);

    MallGrouponRules update(MallGrouponRules ad);

    int delete(MallGrouponRules ad);

}
