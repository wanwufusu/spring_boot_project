package com.springboot.service.admin;

import com.springboot.bean.admin.Role;

import java.util.List;

public interface RoleService {
    List<Role> findRole();

    List<Role> findRoleByPage(int limit, int offset);

    List<Role> findRoleByName(String username);
}
