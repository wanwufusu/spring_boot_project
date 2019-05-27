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
        return roles;
    }

    @Override
    public List<Role> findRoleByName(String username) {
        List<Role> roles = roleMapper.findRoleByName(username);
        return roles;
    }

    @Override
    public boolean addRole(Role role) {
        List<Role> check = roleMapper.findRoleByName(role.getName());
        if(check.size() == 0){
            roleMapper.insert(role);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Role role) {
        int flag = roleMapper.updateByPrimaryKeySelective(role);
        if(flag > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRole(Role role) {
        int flag = roleMapper.deleteByPrimaryKey(role.getId());
        if(flag > 0){
            return true;
        }
        return false;
    }
}
