package com.springboot.service.popularize;

import com.springboot.bean.popularize.MallCoupon;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;

public interface CouponService {

    Result findlist(PageDetail pageDetail,String name,Integer type,Integer status);

    MallCoupon add(MallCoupon ad);

    MallCoupon update(MallCoupon ad);

    int delete(MallCoupon ad);

    MallCoupon findById(int id);
}
