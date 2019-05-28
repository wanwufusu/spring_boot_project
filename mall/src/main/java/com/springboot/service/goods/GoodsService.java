package com.springboot.service.goods;

import com.springboot.bean.goods.MallGoods;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;

import java.util.HashMap;

public interface GoodsService {
    Result<MallGoods> selectPageGoodsByConditions(PageDetail pageDetail, HashMap<String, Object> conditions);
}
