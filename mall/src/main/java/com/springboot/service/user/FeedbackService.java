package com.springboot.service.user;

import com.springboot.bean.user.Feedback;
import com.springboot.bean.user.UserPage;

import java.util.List;

public interface FeedbackService {
    List<Feedback> queryFeedback(UserPage userPage, String id, String username);

    int findCount();
}
