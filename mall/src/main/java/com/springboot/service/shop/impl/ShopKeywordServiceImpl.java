package com.springboot.service.shop.impl;

import com.springboot.bean.shop.MallKeyword;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;
import com.springboot.mapper.shop.MallKeywordMapper;
import com.springboot.service.shop.ShopKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/24
 * @since 1.0.0
 */
@Service
public class ShopKeywordServiceImpl implements ShopKeywordService {
    @Autowired
    MallKeywordMapper mallKeywordMapper;

    @Override
    public Result<MallKeyword> selectPageKeywordByConditions(PageDetail pageDetail, HashMap<String, Object> conditions) {
        pageDetail.setOffset();
        Result<MallKeyword> result = new Result<>();
        result.setItems(mallKeywordMapper.selectByPageDetailAndConditions(pageDetail, conditions));
        result.setTotal(mallKeywordMapper.selectAllRecordsByConditions(conditions));
        return result;
    }

    @Override
    public int insertKeyword(MallKeyword mallKeyword) {
        return mallKeywordMapper.insert(mallKeyword);
    }

    @Override
    public void deleteKeywordById(Integer id) {
        mallKeywordMapper.logicDeleteKeywordById(id);
    }

    @Override
    public int update(MallKeyword mallKeyword) {
        return mallKeywordMapper.updateByPrimaryKey(mallKeyword);
    }
}
