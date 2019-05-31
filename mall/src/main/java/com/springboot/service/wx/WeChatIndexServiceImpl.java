package com.springboot.service.wx;

import com.springboot.bean.util.Result;
import com.springboot.bean.wx.WeChatIndex;
import com.springboot.mapper.goods.MallGoodsMapper;
import com.springboot.mapper.popularize.CouponMapper;
import com.springboot.mapper.popularize.GrouponRuleMapper;
import com.springboot.mapper.popularize.MallAdMapper;
import com.springboot.mapper.shop.MallBrandMapper;
import com.springboot.mapper.shop.MallCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/27
 * @since 1.0.0
 */
@Service
public class WeChatIndexServiceImpl implements WeChatIndexService{
    @Autowired
    MallBrandMapper mallBrandMapper;
    @Autowired
    MallCategoryMapper mallCategoryMapper;
    @Autowired
    MallAdMapper mallAdMapper;
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    MallGoodsMapper mallGoodsMapper;

    @Override
    public WeChatIndex selectIndexDetail() {
        WeChatIndex weChatIndex = new WeChatIndex();
        weChatIndex.setBrandList(mallBrandMapper.selectBrands());
        weChatIndex.setChannel(mallCategoryMapper.selectAllCategorys());
        weChatIndex.setBanner(mallAdMapper.findAllAd());
        weChatIndex.setCouponList(couponMapper.findAllCoupon());
        //weChatIndex.setFloorGoods(mallGoodsMapper.selectFloorGoods());
        return weChatIndex;
    }

}
