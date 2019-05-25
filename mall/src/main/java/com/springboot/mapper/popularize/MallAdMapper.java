package com.springboot.mapper.popularize;

import com.springboot.bean.popularize.MallAd;
import com.springboot.bean.util.PageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MallAdMapper {

    List<MallAd> findList(@Param("page") PageDetail pageDetail,@Param("name") String name,@Param("content") String content);

    int countList(@Param("name") String name,@Param("content") String content);

    /**
     * 返回插入内容自己产生的ID
     * @param ad
     * @return
     */
    int insert (MallAd ad);

    int update(MallAd ad);

    int deleteById(int id);
}
