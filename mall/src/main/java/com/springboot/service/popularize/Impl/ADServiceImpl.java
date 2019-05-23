package com.springboot.service.popularize.Impl;

import com.springboot.bean.popularize.MallAd;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;
import com.springboot.mapper.popularize.MallAdMapper;
import com.springboot.service.popularize.ADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ADServiceImpl implements ADService {
    @Autowired
    MallAdMapper mapper;


    @Override
    public Result findList(PageDetail pageDetail) {
        pageDetail.setOffset();
        List list = mapper.findList(pageDetail.getOffset(), pageDetail.getLimit());
        Result<Object> result = new Result<>(list,mapper.countList());
        return result;
    }

    @Override
    public int add(MallAd ad) {
        return  mapper.insert(ad);
    }
}
