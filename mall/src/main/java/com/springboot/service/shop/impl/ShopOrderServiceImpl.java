package com.springboot.service.shop.impl;

import com.springboot.bean.shop.MallOrder;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;
import com.springboot.mapper.shop.MallOrderMapper;
import com.springboot.service.shop.ShopOrderService;
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
public class ShopOrderServiceImpl implements ShopOrderService {

    @Autowired
    MallOrderMapper mallOrderMapper;

    @Override
    public ResponseVO<Result<MallOrder>> selectPageOrderByConditions(PageDetail pageDetail, 
                                                                     HashMap<String, Object> conditions) {
        pageDetail.setOffset();
        ResponseVO<Result<MallOrder>> responseVO = new ResponseVO<>();
        Result<MallOrder> result = new Result<>();
        result.setItems(mallOrderMapper.selectByPageDetailAndConditions(pageDetail, conditions));
        result.setTotal(mallOrderMapper.selectAllRecordsByConditions(conditions));
        responseVO.setData(result);
        responseVO.setSuccessMsg();
        return responseVO;
    }

    @Override
    public MallOrder selectOrderById(int id) {
        return mallOrderMapper.selectByPrimaryKey(id);
    }
}
