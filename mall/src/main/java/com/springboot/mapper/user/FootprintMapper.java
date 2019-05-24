package com.springboot.mapper.user;

import com.springboot.bean.user.Footprint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FootprintMapper {
    List<Footprint> QueryFootprintByPage(@Param("offset") int offset, @Param("limit") int limit,
                                       @Param("sort")String sort, @Param("order")String order
    );

    int findCount();

    List<Footprint> QueryFootprintBygoodsId(@Param("offset") int offset, @Param("limit") int limit,
                                     @Param("sort")String sort, @Param("order")String order,
                                     @Param("goodsId")String goodsId);

    List<Footprint> QueryFootprintByUserid(@Param("offset") int offset, @Param("limit") int limit,
                                         @Param("sort")String sort, @Param("order")String order,
                                         @Param("userid")String userid);

    List<Footprint> QueryFootprintByUseridAndgoodsId(@Param("offset") int offset, @Param("limit") int limit,
                                              @Param("sort")String sort, @Param("order")String order,
                                              @Param("userid")String userid,@Param("goodsId")String goodsId);
}
