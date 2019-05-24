package com.springboot.service.user.impl;

import com.springboot.bean.user.Address;
import com.springboot.bean.user.UserPage;
import com.springboot.mapper.user.AddressMapper;
import com.springboot.service.user.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public List<Address> queryAddress(UserPage userPage,String userid,String name) {
        int limit = userPage.getLimit();
        int offset = userPage.getOffset();
        String order = userPage.getOrder();
        String sort = userPage.getSort();
        if(userid==null&&name==null) {
            return addressMapper.QueryAddressByPage(offset, limit, sort, order);
        }else if(userid==null&&name!=null){
            return addressMapper.QueryAddressByName(offset, limit, sort, order, name);
        }else if(userid!=null&&name==null){
            return addressMapper.QueryAddressByUserid(offset, limit, sort, order, userid);
        }else{
            return addressMapper.QueryAddressByUseridAndName(offset, limit, sort, order, userid,name);
        }
    }

    @Override
    public int findCount() {
        return addressMapper.findCount();
    }
}
