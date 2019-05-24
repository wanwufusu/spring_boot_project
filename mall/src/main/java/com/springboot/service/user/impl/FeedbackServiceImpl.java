package com.springboot.service.user.impl;

import com.springboot.bean.user.Feedback;
import com.springboot.bean.user.UserPage;
import com.springboot.mapper.user.FeedbackMapper;
import com.springboot.service.user.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackMapper feedbackMapper;
    @Override
    public List<Feedback> queryFeedback(UserPage userPage, String id, String username) {
        int limit = userPage.getLimit();
        int offset = userPage.getOffset();
        String order = userPage.getOrder();
        String sort = userPage.getSort();
        if(id==null&&username==null) {
            return feedbackMapper.QueryFeedbackByPage(offset, limit, sort, order);
        }else if(id==null&&username!=null){
            return feedbackMapper.QueryFeedbackByusername(offset, limit, sort, order, username);
        }else if(id!=null&&username==null){
            return feedbackMapper.QueryFeedbackByid(offset, limit, sort, order, id);
        }else{
            return feedbackMapper.QueryFeedbackByidAndusername(offset, limit, sort, order, id,username);
        }
    }

    @Override
    public int findCount() {
        return feedbackMapper.findCount();
    }
}
