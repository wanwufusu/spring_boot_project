package com.springboot.service.popularize.Impl;

import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;
import com.springboot.mapper.popularize.GrouponMapper;
import com.springboot.service.popularize.GrouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrouponServiceImpl implements GrouponService {
    @Autowired
    GrouponMapper mapper;
    @Override
    public Result findList(PageDetail pageDetail) {
        pageDetail.setOffset();
        return new Result<>(mapper.findList(pageDetail.getOffset(), pageDetail.getLimit()), mapper.countList());
    }
}
