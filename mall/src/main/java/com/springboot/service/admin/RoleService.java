package com.springboot.service.admin;

import com.springboot.bean.admin.Role;

import java.util.List;

public interface RoleService {
    List<Role> findRole();

    List<Role> findRoleByPage(int limit, int offset);

    List<Role> findRoleByName(String username);

    boolean addRole(Role role);

    boolean update(Role role);

    boolean deleteRole(Role role);
}
