package com.springboot.mapper.popularize;



import com.springboot.bean.popularize.MallCoupon;
import com.springboot.bean.util.PageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponMapper {
    List findList (@Param("page") PageDetail pageDetail, @Param("name") String name, @Param("type") Integer type, @Param("status") Integer status);

    int countList(@Param("name") String name, @Param("type") Integer type, @Param("status") Integer status);

    int insert (MallCoupon ad);

    int update(MallCoupon ad);

    int deleteById(int id);

    MallCoupon findById(int id);

    List<MallCoupon> findAllCoupon();
}
