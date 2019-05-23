package com.springboot.service.shop;


import com.springboot.bean.shop.MallRegion;

import java.util.List;

public interface ShopRegionService {
    List<MallRegion> queryAllRegions();
}
