package com.springboot.mapper.popularize;

import com.springboot.bean.popularize.MallTopic;
import com.springboot.bean.util.PageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicMapper {

    List findList (@Param("page") PageDetail pageDetail,@Param("title") String title,@Param("subtitle") String subtitle);

    int countList(@Param("title") String title,@Param("subtitle") String subtitle);

    int insert (MallTopic topic);

    int update(MallTopic topic);

    int deleteById(int id);
}
