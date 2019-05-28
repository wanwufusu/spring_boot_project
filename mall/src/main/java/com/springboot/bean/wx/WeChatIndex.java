package com.springboot.bean.wx;

import com.springboot.bean.goods.MallGoods;
import com.springboot.bean.popularize.MallAd;
import com.springboot.bean.popularize.MallCoupon;
import com.springboot.bean.popularize.MallGroupon;
import com.springboot.bean.popularize.MallTopic;
import com.springboot.bean.shop.MallBrand;
import com.springboot.bean.shop.MallCategory;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/27
 * @since 1.0.0
 */

public class WeChatIndex {
    private List<MallAd> banner;

    private List<MallBrand> brandList;
    private List<MallCategory> channel;

    private List<MallCoupon> couponList;
    private List<FloorGoods> floorGoods;
    private List<MallGroupon> grouponList;
    private List<MallGoods> hotGoodsList;
    private List<MallGoods> newGoodsList;
    private List<MallTopic> topicList;

    public List<MallAd> getBanner() {
        return banner;
    }

    public void setBanner(List<MallAd> banner) {
        this.banner = banner;
    }

    public List<MallBrand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<MallBrand> brandList) {
        this.brandList = brandList;
    }

    public List<MallCategory> getChannel() {
        return channel;
    }

    public void setChannel(List<MallCategory> channel) {
        this.channel = channel;
    }

    public List<MallCoupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<MallCoupon> couponList) {
        this.couponList = couponList;
    }

    public List<FloorGoods> getFloorGoods() {
        return floorGoods;
    }

    public void setFloorGoods(List<FloorGoods> floorGoods) {
        this.floorGoods = floorGoods;
    }

    public List<MallGroupon> getGrouponList() {
        return grouponList;
    }

    public void setGrouponList(List<MallGroupon> grouponList) {
        this.grouponList = grouponList;
    }

    public List<MallGoods> getHotGoodsList() {
        return hotGoodsList;
    }

    public void setHotGoodsList(List<MallGoods> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
    }

    public List<MallGoods> getNewGoodsList() {
        return newGoodsList;
    }

    public void setNewGoodsList(List<MallGoods> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }

    public List<MallTopic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<MallTopic> topicList) {
        this.topicList = topicList;
    }
}
