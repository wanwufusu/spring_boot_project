package com.springboot.service.shop;

import com.springboot.bean.shop.MallOrder;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;

import java.util.HashMap;

public interface ShopOrderService {
    ResponseVO<Result<MallOrder>> selectPageOrderByConditions(PageDetail pageDetail, HashMap<String, Object> conditions);

    MallOrder selectOrderById(int id);
}
