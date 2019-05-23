package com.springboot.service.popularize.Impl;

import com.springboot.bean.PageDetail;
import com.springboot.bean.Result;
import com.springboot.mapper.popularize.TopicMapper;
import com.springboot.service.popularize.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper mapper;

    @Override
    public Result findlist(PageDetail pageDetail) {
        pageDetail.setOffset();
        return new Result<>(mapper.findList(pageDetail.getOffset(), pageDetail.getLimit()),mapper.countList());
    }
}
