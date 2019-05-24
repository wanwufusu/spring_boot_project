package com.springboot.service.user.impl;

import com.springboot.bean.user.Footprint;
import com.springboot.bean.user.UserPage;
import com.springboot.mapper.user.FootprintMapper;
import com.springboot.service.user.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FootprintServiceImpl implements FootprintService {

    @Autowired
    FootprintMapper footprintMapper;
    @Override
    public List<Footprint> queryFootprint(UserPage userPage, String userid, String goodsId) {
        int limit = userPage.getLimit();
        int offset = userPage.getOffset();
        String order = userPage.getOrder();
        String sort = userPage.getSort();
        if(userid==null&&goodsId==null) {
            return footprintMapper.QueryFootprintByPage(offset, limit, sort, order);
        }else if(userid==null&&goodsId!=null){
            return footprintMapper.QueryFootprintBygoodsId(offset, limit, sort, order, goodsId);
        }else if(userid!=null&&goodsId==null){
            return footprintMapper.QueryFootprintByUserid(offset, limit, sort, order, userid);
        }else{
            return footprintMapper.QueryFootprintByUseridAndgoodsId(offset, limit, sort, order, userid,goodsId);
        }
    }

    @Override
    public int findCount() {
        return 0;
    }
}
