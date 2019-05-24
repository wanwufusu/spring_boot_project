package com.springboot.mapper.popularize;

import com.springboot.bean.popularize.MallCoupon;
import com.springboot.bean.util.PageDetail;

import java.util.List;

public interface CouponMapper {
    List findList (PageDetail pageDetail);

    int countList();

    int insert (MallCoupon ad);

    int update(MallCoupon ad);

    int deleteById(int id);

    MallCoupon findById(int id);
}
