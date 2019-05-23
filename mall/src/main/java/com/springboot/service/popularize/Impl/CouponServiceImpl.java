package com.springboot.service.popularize.Impl;

import com.springboot.bean.PageDetail;
import com.springboot.bean.Result;
import com.springboot.mapper.popularize.CouponMapper;
import com.springboot.service.popularize.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    CouponMapper mapper;

    @Override
    public Result findlist(PageDetail pageDetail) {
        pageDetail.setOffset();
        return new Result<>(mapper.findList(pageDetail.getOffset(), pageDetail.getLimit()),mapper.countList());
    }
}
