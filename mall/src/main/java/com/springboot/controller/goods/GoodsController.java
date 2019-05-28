package com.springboot.controller.goods;

import com.springboot.bean.goods.MallGoods;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;
import com.springboot.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/27
 * @since 1.0.0
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("list")
    public ResponseVO<Result<MallGoods>> selectPageGoods(PageDetail pageDetail, String question){
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("abc", question);
        ResponseVO<Result<MallGoods>> responseVO = new ResponseVO<>();
        Result<MallGoods> result =  goodsService.selectPageGoodsByConditions(pageDetail, conditions);
        responseVO.setData(result);
        responseVO.setSuccessMsg();
        return responseVO;
    }


}
