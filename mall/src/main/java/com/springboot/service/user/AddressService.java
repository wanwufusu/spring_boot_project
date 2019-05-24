package com.springboot.service.user;

import com.springboot.bean.user.Address;
import com.springboot.bean.user.UserPage;

import java.util.List;

public interface AddressService {
    List<Address> queryAddress(UserPage userPage,String userid,String name);

    int findCount();
}
