package com.springboot.service.user.impl;

import com.springboot.bean.user.User;
import com.springboot.bean.user.UserPage;
import com.springboot.mapper.user.UserMapper;


import com.springboot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> queryUser(UserPage userPage) {
        int limit = userPage.getLimit();
        int offset = userPage.getOffset();
        String order = userPage.getOrder();
        String sort = userPage.getSort();
        List<User> users = userMapper.QueryUsersByPage(offset, limit, sort, order);
        return users;
    }

    @Override
    public int findCount() {
        return userMapper.findCount();
    }

    @Override
    public List<User> queryUserByMobile(String mobile,UserPage userPage) {
        int limit = userPage.getLimit();
        int offset = userPage.getOffset();
        String order = userPage.getOrder();
        String sort = userPage.getSort();
        return userMapper.QueryUsersByMobile(mobile,offset, limit, sort, order);
    }

    @Override
    public List<User> queryUserByUsername(String username,UserPage userPage) {
        int limit = userPage.getLimit();
        int offset = userPage.getOffset();
        String order = userPage.getOrder();
        String sort = userPage.getSort();
        return userMapper.QueryUsersByUsername(username,offset, limit, sort, order);
    }
}
