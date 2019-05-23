package com.springboot.service.user.impl;

import com.springboot.bean.user.User;
import com.springboot.bean.user.UserPage;
import com.springboot.mapper.user.UserMapper;


import com.springboot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> queryUser(UserPage userPage) {
        int limit = userPage.getLimit();
        int offset = userPage.getOffset();
        String order = userPage.getOrder();
        String sort = userPage.getSort();
        return userMapper.QueryUsersByPage(limit,offset,sort,order);
    }
}
