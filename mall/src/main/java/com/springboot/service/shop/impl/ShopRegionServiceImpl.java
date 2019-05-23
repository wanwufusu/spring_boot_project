package com.springboot.service.shop.impl;

import com.springboot.bean.shop.MallRegion;
import com.springboot.mapper.shop.MallRegionMapper;
import com.springboot.service.shop.ShopRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈行政区域查找〉
 *
 * @author Ruimingz
 * @create 2019/5/22
 * @since 1.0.0
 */
@Service
public class ShopRegionServiceImpl implements ShopRegionService {

    @Autowired
    MallRegionMapper mallRegionMapper;


    @Override
    public List<MallRegion> queryAllRegions() {
        List<MallRegion> mallRegions = mallRegionMapper.selectAllRegions();
        return mallRegions;
    }
}
