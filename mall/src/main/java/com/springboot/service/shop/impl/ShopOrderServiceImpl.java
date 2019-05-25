package com.springboot.service.shop.impl;

import com.springboot.bean.shop.MallOrder;
import com.springboot.bean.shop.MallOrderGoods;
import com.springboot.bean.shop.OrderDetail;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;
import com.springboot.mapper.shop.MallOrderGoodsMapper;
import com.springboot.mapper.shop.MallOrderMapper;
import com.springboot.mapper.user.UserMapper;
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

    @Autowired
    MallOrderGoodsMapper mallOrderGoodsMapper;

    @Autowired
    UserMapper userMapper;

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

    @Override
    public OrderDetail selectOrderDetailById(int id) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(mallOrderMapper.selectByPrimaryKey(id));
        orderDetail.setOrderGoods(mallOrderGoodsMapper.selectOrderGoods());
        orderDetail.setUser(userMapper.queryUserById(id));
        return orderDetail;
    }
}
