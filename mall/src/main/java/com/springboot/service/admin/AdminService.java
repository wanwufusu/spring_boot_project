package com.springboot.service.admin;

import com.springboot.bean.admin.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> findAdminByPage(int rows, int offset);

    boolean addAdmin(Admin admin);

    boolean epdate(Admin admin);

    boolean deleteAdmin(Admin admin);

    List<Admin> findAdminByName(String username);
}
