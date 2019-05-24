package com.springboot.service.shop;

import com.springboot.bean.shop.MallKeyword;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;

import java.util.HashMap;

public interface ShopKeywordService {
    Result<MallKeyword> selectPageKeywordByConditions(PageDetail pageDetail, HashMap<String, Object> conditions);

    int insertKeyword(MallKeyword mallKeyword);

    void deleteKeywordById(Integer id);

    int update(MallKeyword mallKeyword);
}
