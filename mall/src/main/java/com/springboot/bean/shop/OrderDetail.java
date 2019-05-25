package com.springboot.bean.shop;

import com.springboot.bean.user.User;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/24
 * @since 1.0.0
 */

public class OrderDetail {
    private MallOrder order;

    private List<MallOrderGoods> orderGoods;

    private User user;

    public MallOrder getOrder() {
        return order;
    }

    public void setOrder(MallOrder order) {
        this.order = order;
    }

    public List<MallOrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<MallOrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
