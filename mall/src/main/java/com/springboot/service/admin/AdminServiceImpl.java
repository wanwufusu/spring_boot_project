package com.springboot.service.admin;

import com.springboot.bean.admin.Admin;
import com.springboot.mapper.admin.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> findAdminByPage(int rows, int offset) {
        List<Admin> admins = adminMapper.findAdminByPage(rows,offset);
        return admins;
    }

    @Override
    public List<Admin> findAdminByName(String username) {
        List<Admin> admins = adminMapper.findAdminByName(username);
        return admins;
    }

    @Override
    public boolean addAdmin(Admin admin) {
        List<Admin> check = adminMapper.findAdminByName(admin.getUsername());
        if(check.size() == 0){
            adminMapper.insert(admin);
            return true;
        }
        return false;
    }

    @Override
    public boolean epdate(Admin admin) {
        int i = adminMapper.updateByPrimaryKeySelective(admin);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAdmin(Admin admin) {
        int flag = adminMapper.deleteByPrimaryKey(admin.getId());
        if(flag > 0){
            return true;
        }
        return false;
    }
}
