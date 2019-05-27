package com.springboot.controller.shop;

import com.springboot.bean.shop.MallOrder;
import com.springboot.bean.shop.OrderDetail;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;
import com.springboot.service.shop.ShopOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/24
 * @since 1.0.0
 */
@RestController
@RequestMapping("order")
public class ShopOrderController {

    @Autowired
    ShopOrderService shopOrderService;

    @RequestMapping("list")
    public ResponseVO<Result<MallOrder>> selectPageOrder(PageDetail pageDetail,
                                                         String userId, String orderSn, String[] orderStatusArray){
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("userId", userId);
        conditions.put("orderSn", orderSn);
        conditions.put("orderStatusArray", orderStatusArray);
        return shopOrderService.selectPageOrderByConditions(pageDetail, conditions);
    }

    @RequestMapping("detail")
    public ResponseVO<OrderDetail> selectOrderById(String id){
        OrderDetail orderDetail = shopOrderService.selectOrderDetailById(Integer.parseInt(id));
        ResponseVO<OrderDetail> responseVO = new ResponseVO<>();
/*        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("order", mallOrder);
        resultMap.put("orderGoods", new String[]{});
        resultMap.put("user", null);*/
        responseVO.setSuccessMsg();
        responseVO.setData(orderDetail);
        return responseVO;
    }
}
