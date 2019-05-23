package com.springboot.controller.popularize;


import com.springboot.bean.PageDetail;
import com.springboot.bean.ResponseVO;
import com.springboot.bean.Result;
import com.springboot.service.popularize.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("coupon")
public class CouponController {

    @Autowired
    CouponService service;

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO couponlist(PageDetail pageDetail){
        Result result = service.findlist(pageDetail);
        ResponseVO vo = new ResponseVO(result, "成功", 0);
        return vo;
    }
}
