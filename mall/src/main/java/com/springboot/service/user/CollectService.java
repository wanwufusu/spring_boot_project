package com.springboot.service.user;

import com.springboot.bean.user.Collect;
import com.springboot.bean.user.UserPage;

import java.util.List;

public interface CollectService {
    List<Collect> queryCollect(UserPage userPage, String userid, String valueId);

    int findCount();
}
