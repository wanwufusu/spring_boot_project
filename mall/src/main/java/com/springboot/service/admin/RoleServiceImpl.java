package com.springboot.service.admin;

import com.springboot.bean.admin.Role;
import com.springboot.mapper.admin.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Role> findRole() {
        List<Role> roles = roleMapper.findRole();
        return roles;
    }

    @Override
    public List<Role> findRoleByPage(int limit, int offset) {
        List<Role> roles = roleMapper.findRoleByPage(limit,offset);
        return null;
    }

    @Override
    public List<Role> findRoleByName(String username) {
        List<Role> roles = roleMapper.findRoleByName(username);
        return null;
    }
}
