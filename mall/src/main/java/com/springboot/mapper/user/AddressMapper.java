package com.springboot.mapper.user;

import com.springboot.bean.user.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    List<Address> QueryAddressByPage(@Param("offset") int offset, @Param("limit") int limit,
                                     @Param("sort")String sort, @Param("order")String order
                                     );

    int findCount();

    List<Address> QueryAddressByName(@Param("offset") int offset, @Param("limit") int limit,
                                        @Param("sort")String sort, @Param("order")String order,
                                        @Param("name")String name);

    List<Address> QueryAddressByUserid(@Param("offset") int offset, @Param("limit") int limit,
                                       @Param("sort")String sort, @Param("order")String order,
                                       @Param("userid")String userid);

    List<Address> QueryAddressByUseridAndName(@Param("offset") int offset, @Param("limit") int limit,
                                                 @Param("sort")String sort, @Param("order")String order,
                                                 @Param("userid")String userid,@Param("name")String name);
}
