package com.springboot.service.shop;

import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;
import com.springboot.bean.shop.MallBrand;

public interface ShopBrandService {
    /**
     * 根据页面信息查找对应数量的品牌商
     * @param pageDetail 页面信息
     * @return 返回一个VO，包含品牌商集合，总数量及操作状态
     */
    ResponseVO<Result<MallBrand>> selectPageBrand(PageDetail pageDetail);

    int insertBrand(MallBrand mallBrand);
}
