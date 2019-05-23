package com.springboot.service.user;

import com.springboot.bean.user.User;
import com.springboot.bean.user.UserPage;

import java.util.List;

public interface UserService {
    List<User> queryUser(UserPage userPage);

    int findCount();

    List<User> queryUserByMobile(String mobile,UserPage userPage);

    List<User> queryUserByUsername(String username,UserPage userPage);
}
