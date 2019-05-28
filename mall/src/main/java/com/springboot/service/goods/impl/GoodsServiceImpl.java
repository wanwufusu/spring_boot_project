package com.springboot.service.goods.impl;

import com.springboot.bean.goods.MallGoods;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;
import com.springboot.mapper.goods.MallGoodsMapper;
import com.springboot.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/27
 * @since 1.0.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    MallGoodsMapper mallGoodsMapper;

    @Override
    public Result<MallGoods> selectPageGoodsByConditions(PageDetail pageDetail, HashMap<String, Object> conditions) {
        pageDetail.setOffset();
        Result<MallGoods> result = new Result<>();
        result.setItems(mallGoodsMapper.selectByPageDetailAndConditions(pageDetail, conditions));
        result.setTotal(mallGoodsMapper.selectAllRecordsByConditions(conditions));
        return result;
    }
}
