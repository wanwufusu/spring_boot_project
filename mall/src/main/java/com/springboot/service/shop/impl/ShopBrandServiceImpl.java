package com.springboot.service.shop.impl;

import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;
import com.springboot.bean.shop.MallBrand;
import com.springboot.mapper.shop.MallBrandMapper;
import com.springboot.service.shop.ShopBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    public ResponseVO<Result<MallBrand>> selectPageBrandByConditions(PageDetail pageDetail, Map conditions) {
        pageDetail.setOffset();
        ResponseVO<Result<MallBrand>> responseVO = new ResponseVO<>();
        Result<MallBrand> result = new Result<>();
        result.setItems(mallBrandMapper.selectByPageDetailAndConditions(pageDetail, conditions));
        result.setTotal(mallBrandMapper.selectAllRecordsByConditions(conditions));
        responseVO.setData(result);
        responseVO.setSuccessMsg();
        return responseVO;
    }

    @Override
    public int insertBrand(MallBrand mallBrand) {
        return mallBrandMapper.insert(mallBrand);
    }

    @Override
    public void deleteBrandById(Integer id) {
        mallBrandMapper.logicDeleteBrandById(id);
    }

    @Override
    public int update(MallBrand mallBrand) {
        return mallBrandMapper.updateByPrimaryKey(mallBrand);
    }
}
