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
    public Result findList(PageDetail pageDetail,String name,String content) {
        pageDetail.setOffset();
        List list = mapper.findList(pageDetail,name,content);
        Result<Object> result = new Result<>(list,mapper.countList(name,content));
        return result;
    }

    @Override
    public MallAd add(MallAd ad) {
        int insert = mapper.insert(ad);
        if (insert!=0){
            ad.setId(insert);
            return ad;
        }else
            return null;
    }
    @Override
    public MallAd update(MallAd ad) {
        int update = mapper.update(ad);
        if (update!=0){
            ad.setId(update);
            return ad;
        }else
            return null;
    }

    @Override
    public int delete(MallAd ad) {
        Integer id = ad.getId();
        return mapper.deleteById(id);
    }
}
