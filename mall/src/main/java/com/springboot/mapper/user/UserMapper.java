package com.springboot.mapper.user;


import com.springboot.bean.user.User;
import com.springboot.bean.user.UserExample;
import com.springboot.bean.user.UserPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /*User selectByPrimaryKey(@Param("id") Integer id);*/
//按某列增序分页查询
    List<User> QueryUsersByPage(@Param("offset") int offset,@Param("limit") int limit,@Param("sort")String sort,@Param("order")String order);

    int findCount();

    List<User> QueryUsersByMobile(@Param("mobile")String mobile,@Param("offset") int offset,@Param("limit") int limit,@Param("sort")String sort,@Param("order")String order);

    List<User> QueryUsersByUsername(@Param("username")String username,@Param("offset") int offset,@Param("limit") int limit,@Param("sort")String sort,@Param("order")String order);
}
