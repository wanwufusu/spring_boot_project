package com.springboot.mapper.popularize;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrouponMapper {

    List findList(@Param("offset") int offset,@Param("limit") int limit);

    int countList();
}
