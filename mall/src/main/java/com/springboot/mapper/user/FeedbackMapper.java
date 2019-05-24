package com.springboot.mapper.user;

import com.springboot.bean.user.Feedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackMapper {
    List<Feedback> QueryFeedbackByPage(@Param("offset") int offset, @Param("limit") int limit,
                                     @Param("sort")String sort, @Param("order")String order
    );

    int findCount();

    List<Feedback> QueryFeedbackByusername(@Param("offset") int offset, @Param("limit") int limit,
                                     @Param("sort")String sort, @Param("order")String order,
                                     @Param("username")String username);

    List<Feedback> QueryFeedbackByid(@Param("offset") int offset, @Param("limit") int limit,
                                       @Param("sort")String sort, @Param("order")String order,
                                       @Param("id")String id);

    List<Feedback> QueryFeedbackByidAndusername(@Param("offset") int offset, @Param("limit") int limit,
                                                @Param("sort")String sort, @Param("order")String order,
                                                @Param("id")String id, @Param("username")String username);
}
