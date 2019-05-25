package com.springboot.mapper.popularize;

import com.springboot.bean.popularize.MallGrouponRules;
import com.springboot.bean.util.PageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrouponRuleMapper {

    List findList(@Param("page") PageDetail pageDetail,@Param("goodsId")Integer goodsId);

    int countList(@Param("goodsId") Integer goodsId);

    int insert (MallGrouponRules groupon);

    int update(MallGrouponRules groupon);

    int deleteById(int id);
}
