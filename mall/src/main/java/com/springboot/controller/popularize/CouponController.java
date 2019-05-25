package com.springboot.controller.popularize;


import com.springboot.bean.popularize.MallCoupon;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;
import com.springboot.service.popularize.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("coupon")
@RestController
public class CouponController {

    @Autowired
    CouponService service;

    @RequestMapping("list")
    public ResponseVO couponlist(PageDetail pageDetail,String name,Integer type,Integer status){
        Result result = service.findlist(pageDetail,name,type,status);
        ResponseVO vo = new ResponseVO(result, "成功", 0);
        return vo;
    }

    @RequestMapping("create")
    public ResponseVO create(@RequestBody MallCoupon coupon){
        MallCoupon add = service.add(coupon);
        if (add != null){
            return new ResponseVO(add,"成功",0);
        }else return new ResponseVO(null,"失败",-1);
    }

    @RequestMapping("update")
    public ResponseVO update(@RequestBody MallCoupon coupon){
        MallCoupon update = service.update(coupon);
        if (update != null){
            return new ResponseVO(update,"成功",0);
        }else return new ResponseVO(null,"失败",-1);
    }

    @RequestMapping("delete")
    public ResponseVO delete(@RequestBody MallCoupon coupon){
        int i = service.delete(coupon);
        if (i>=1){
            return new ResponseVO(null,"成功",0);
        }else {
            return new ResponseVO(null,"失败",-1);
        }
    }

    @RequestMapping("read")
    public ResponseVO read (int id){
        MallCoupon byid = service.findById(id);
        if (byid != null){
            return new ResponseVO(byid,"查询成功",0);
        }else return new ResponseVO(null,"错误",-1);
    }


    /**
     * 根据couponID查coupon_user
     * @param pageDetail
     * @param couponId
     * @return
     */
    @RequestMapping("listuser")
    public ResponseVO listuser (PageDetail pageDetail,int couponId){
        return new ResponseVO(null,"还没做呢",0);
    }

    /**
     * 一个外连接查询
     * @param pageDetail
     * @return
     */
    @RequestMapping("listRecord")
    public ResponseVO listRecord (PageDetail pageDetail){
        return new ResponseVO(null,"不知道这里是干嘛的",0);
    }
}
