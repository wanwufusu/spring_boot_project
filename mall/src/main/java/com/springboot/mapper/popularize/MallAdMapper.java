package com.springboot.mapper.popularize;

import com.springboot.bean.popularize.MallAd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallAdMapper {

    List<MallAd> findList(@Param("offset") int offset,@Param("limit") int limit);

    int countList();
    int insert (MallAd ad);
}
