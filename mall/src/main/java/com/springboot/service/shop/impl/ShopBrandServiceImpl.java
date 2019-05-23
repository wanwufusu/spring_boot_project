package com.springboot.service.shop.impl;

import com.springboot.bean.PageDetail;
import com.springboot.bean.ResponseVO;
import com.springboot.bean.Result;
import com.springboot.bean.shop.MallBrand;
import com.springboot.mapper.shop.MallBrandMapper;
import com.springboot.service.shop.ShopBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/23
 * @since 1.0.0
 */
@Service
public class ShopBrandServiceImpl implements ShopBrandService{
    @Autowired
    MallBrandMapper mallBrandMapper;

    @Override
    public ResponseVO<Result<MallBrand>> selectPageBrand(PageDetail pageDetail) {
        pageDetail.setOffset();
        ResponseVO<Result<MallBrand>> responseVO = new ResponseVO<>();
        Result<MallBrand> result = new Result<>();
        result.setItems(mallBrandMapper.selectByPageDetail(pageDetail));
        result.setTotal(mallBrandMapper.selectAllRecords());
        responseVO.setData(result);
        responseVO.setSuccessMsg();
        return responseVO;
    }
}
