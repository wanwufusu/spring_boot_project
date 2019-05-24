package com.springboot.mapper.popularize;

import com.springboot.bean.popularize.MallTopic;
import com.springboot.bean.util.PageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicMapper {

    List findList (PageDetail pageDetail);

    int countList();

    int insert (MallTopic topic);

    int update(MallTopic topic);

    int deleteById(int id);
}
