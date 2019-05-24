package com.springboot.service.popularize.Impl;

import com.springboot.bean.popularize.MallTopic;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.Result;
import com.springboot.mapper.popularize.TopicMapper;
import com.springboot.service.popularize.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper mapper;

    @Override
    public Result findlist(PageDetail pageDetail) {
        pageDetail.setOffset();
        return new Result<>(mapper.findList(pageDetail),mapper.countList());
    }



    @Override
    public MallTopic add(MallTopic topic) {
        int insert = mapper.insert(topic);
        if (insert!=0){
            topic.setId(insert);
            return topic;
        }else
            return null;
    }
    @Override
    public MallTopic update(MallTopic topic) {
        int update = mapper.update(topic);
        if (update!=0){
            topic.setId(update);
            return topic;
        }else
            return null;
    }

    @Override
    public int delete(MallTopic topic) {
        Integer id = topic.getId();
        return mapper.deleteById(id);
    }
}
