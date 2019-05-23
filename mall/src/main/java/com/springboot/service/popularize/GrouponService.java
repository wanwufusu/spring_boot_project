package com.springboot.service.popularize;

import com.springboot.bean.PageDetail;
import com.springboot.bean.Result;

public interface GrouponService {

    Result findList(PageDetail pageDetail);
}
