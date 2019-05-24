package com.springboot.service.popularize;

import com.springboot.bean.popularize.MallTopic;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;

public interface TopicService {

    Result findlist(PageDetail pageDetail);

    MallTopic add(MallTopic ad);

    MallTopic update(MallTopic ad);

    int delete(MallTopic ad);
}
