package com.springboot.service.user.impl;

import com.springboot.bean.user.Collect;
import com.springboot.bean.user.UserPage;
import com.springboot.mapper.user.CollectMapper;
import com.springboot.service.user.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;

    @Override
    public List<Collect> queryCollect(UserPage userPage, String userid, String valueId) {
        int limit = userPage.getLimit();
        int offset = userPage.getOffset();
        String order = userPage.getOrder();
        String sort = userPage.getSort();
        if(userid==null&&valueId==null) {
            return collectMapper.QueryAddressByPage(offset, limit, sort, order);
        }else if(userid==null&&valueId!=null){
            return collectMapper.QueryAddressByvalueId(offset, limit, sort, order, valueId);
        }else if(userid!=null&&valueId==null){
            return collectMapper.QueryAddressByUserid(offset, limit, sort, order, userid);
        }else{
            return collectMapper.QueryAddressByUseridAndvalueId(offset, limit, sort, order, userid,valueId);
        }
    }

    @Override
    public int findCount() {
        return 0;
    }
}
