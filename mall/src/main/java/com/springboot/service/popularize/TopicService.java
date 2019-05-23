package com.springboot.service.popularize;

import com.springboot.bean.PageDetail;
import com.springboot.bean.Result;

public interface TopicService {

    Result findlist(PageDetail pageDetail);

}
