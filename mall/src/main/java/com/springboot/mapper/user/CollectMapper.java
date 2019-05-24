package com.springboot.mapper.user;

import com.springboot.bean.user.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    List<Collect> QueryAddressByPage(@Param("offset") int offset, @Param("limit") int limit,
                                     @Param("sort")String sort, @Param("order")String order
    );

    int findCount();

    List<Collect> QueryAddressByvalueId(@Param("offset") int offset, @Param("limit") int limit,
                                     @Param("sort")String sort, @Param("order")String order,
                                     @Param("valueId")String valueId);

    List<Collect> QueryAddressByUserid(@Param("offset") int offset, @Param("limit") int limit,
                                       @Param("sort")String sort, @Param("order")String order,
                                       @Param("userid")String userid);

    List<Collect> QueryAddressByUseridAndvalueId(@Param("offset") int offset, @Param("limit") int limit,
                                              @Param("sort")String sort, @Param("order")String order,
                                              @Param("userid")String userid,@Param("valueId")String valueId);
}
