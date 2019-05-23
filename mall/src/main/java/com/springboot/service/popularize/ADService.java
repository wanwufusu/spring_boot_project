package com.springboot.service.popularize;

import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;

public interface ADService {

    Result findList(PageDetail pageDetail);
}
