package com.springboot.service.popularize;

import com.springboot.bean.PageDetail;
import com.springboot.bean.Result;
import com.springboot.bean.popularize.MallAd;

import java.util.List;

public interface ADService {

    Result findList(PageDetail pageDetail);
}
