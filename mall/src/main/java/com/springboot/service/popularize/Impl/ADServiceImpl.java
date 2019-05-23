package com.springboot.service.popularize.Impl;

import com.springboot.bean.PageDetail;
import com.springboot.bean.Result;
import com.springboot.bean.popularize.MallAd;
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
}
