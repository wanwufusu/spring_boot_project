package com.springboot.bean.wx;

import com.springboot.bean.goods.MallGoods;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/27
 * @since 1.0.0
 */

public class FloorGoods {

    private int id;

    private String name;

    private List<MallGoods> goodsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MallGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<MallGoods> goodsList) {
        this.goodsList = goodsList;
    }
}
