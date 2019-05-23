package com.springboot.controller.shop;

import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.shop.MallRegion;
import com.springboot.service.shop.ShopRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/22
 * @since 1.0.0
 */
@RestController
public class ShopRegionController {

    @Autowired
    ShopRegionService shopRegionService;

    @RequestMapping("region/list")
    public ResponseVO<List<MallRegion>> queryRegions(){
        List<MallRegion> mallRegions = shopRegionService.queryAllRegions();
        return new ResponseVO<List<MallRegion>>(mallRegions, "成功", 0);
    }


}
