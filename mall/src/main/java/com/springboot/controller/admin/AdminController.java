package com.springboot.controller.admin;

import com.springboot.bean.admin.Admin;
import com.springboot.bean.admin.Data;
import com.springboot.bean.admin.ResponseVo;
import com.springboot.bean.admin.ResponseVp;
import com.springboot.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo list(int page,int limit,String username){
        if(username == null){
        int offset = (page - 1) * limit;
        List<Admin> admins = adminService.findAdminByPage(limit,offset);
        Data<Admin> adminData = new Data<>();
        adminData.setItems(admins);
        adminData.setTotal(admins == null?0:admins.size());
        return new ResponseVo(0,adminData,"成功");
        }else {
            List<Admin> admins = adminService.findAdminByName(username);
            Data<Admin> adminData = new Data<>();
            adminData.setItems(admins);
            adminData.setTotal(admins == null?0:admins.size());
            return new ResponseVo(0,adminData,"成功");
        }

    }
    @RequestMapping("create")
    @ResponseBody
    public ResponseVp create(@RequestBody Admin admin) {
        if(admin.getPassword().length() < 6){
            return new ResponseVp(602,null,"管理员密码长度不能小于6");
        }else if(admin.getUsername().length() < 6){
            return new ResponseVp(601,null,"管理员名称不符合规定");
        }
        boolean flag = adminService.addAdmin(admin);
        if (flag) {
            return new ResponseVp(0,admin,"成功");
        }else {
            return new ResponseVp(602,null,"管理员已经存在");
        }
    }
    @RequestMapping("update")
    @ResponseBody
    public ResponseVp update(@RequestBody Admin admin){
        if(admin.getPassword().length() < 6){
            return new ResponseVp(602,null,"管理员密码长度不能小于6");
        }else if(admin.getUsername().length() < 6){
            return new ResponseVp(601,null,"管理员名称不符合规定");
        }
        boolean flag = adminService.epdate(admin);
        if(flag){
            return new ResponseVp(0,admin,"成功");
        }else {
            return null;
        }
    }
    @RequestMapping("delete")
    @ResponseBody
    public ResponseVp delete(@RequestBody Admin admin){
        boolean flag = adminService.deleteAdmin(admin);
        if(flag){
            return new ResponseVp(0,null,"成功");
        }else {
            return null;
        }
    }
}
