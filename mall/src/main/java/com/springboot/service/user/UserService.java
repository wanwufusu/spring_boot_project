package com.springboot.service.user;

import com.springboot.bean.user.User;
import com.springboot.bean.user.UserPage;

import java.util.List;

public interface UserService {
    List<User> queryUser(UserPage userPage);
}
