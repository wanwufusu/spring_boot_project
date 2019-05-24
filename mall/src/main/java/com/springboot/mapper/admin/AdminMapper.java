package com.springboot.mapper.admin;

import com.springboot.bean.admin.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> findAdminByPage(@Param("rows") int rows, @Param("offset") int offset);

    List<Admin> findAdminByName(@Param("name") String username);
}