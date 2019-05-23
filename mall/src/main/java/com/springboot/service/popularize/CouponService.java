package com.springboot.service.popularize;

import com.springboot.bean.PageDetail;
import com.springboot.bean.Result;

public interface CouponService {

    Result findlist(PageDetail pageDetail);
}
