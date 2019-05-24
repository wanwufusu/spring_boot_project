package com.springboot.service.user;

import com.springboot.bean.user.Footprint;
import com.springboot.bean.user.UserPage;

import java.util.List;

public interface FootprintService {
    List<Footprint> queryFootprint(UserPage userPage, String userid, String goodsId);

    int findCount();
}
