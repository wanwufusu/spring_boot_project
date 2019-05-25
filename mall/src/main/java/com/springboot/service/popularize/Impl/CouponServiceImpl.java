package com.springboot.service.popularize.Impl;

import com.springboot.bean.popularize.MallCoupon;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;
import com.springboot.mapper.popularize.CouponMapper;
import com.springboot.service.popularize.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    CouponMapper mapper;

    @Override
    public Result findlist(PageDetail pageDetail,String name,Integer type,Integer status) {
        pageDetail.setOffset();
        List list = mapper.findList(pageDetail, name, type, status);
        int i = mapper.countList(name, type, status);
        return new Result<>(list,i);
    }

    @Override
    public MallCoupon add(MallCoupon coupon) {
        int insert = mapper.insert(coupon);
        if (insert!=0){
            coupon.setId(insert);
            return coupon;
        }else
            return null;
    }
    @Override
    public MallCoupon update(MallCoupon coupon) {
        int update = mapper.update(coupon);
        if (update!=0){
            coupon.setId(update);
            return coupon;
        }else
            return null;
    }

    @Override
    public int delete(MallCoupon coupon) {
        Integer id = coupon.getId();
        return mapper.deleteById(id);
    }

    @Override
    public MallCoupon findById(int id) {
        return mapper.findById(id);
    }
}
