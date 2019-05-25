package com.springboot.service.popularize;

import com.springboot.bean.popularize.MallAd;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;

public interface ADService {

    Result findList(PageDetail pageDetail,String name,String content);

    MallAd add(MallAd ad);

    MallAd update(MallAd ad);

    int delete(MallAd ad);
}
