package com.springboot.controller.admin;

import com.springboot.bean.admin.*;
import com.springboot.bean.util.ResponseVO;
import com.springboot.service.admin.RoleService;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @RequestMapping("options")
    @ResponseBody
    public ResponseVO<List<HashMap>> options(){
        List<Role> roles = roleService.findRole();
        /*List<RoleData> data = new ArrayList<>();
        RoleData roleData = new RoleData(null,0);
        for(Role role : roles){
            roleData.setLabel(role.getName());
            roleData.setValue(role.getId());
            data.add(roleData);
        }*/

        List<HashMap> data = new ArrayList<>();
        for(Role role : roles){
            HashMap<String,Object> map = new HashMap<>();
            map.put("label",role.getName());
            map.put("value",role.getId());
            data.add(map);
        }

        return new ResponseVO<>(data,"成功",0);
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo list(int page,int limit,String username){
        if(username == null){
            int offset = (page - 1) * limit;
            List<Role> roles = roleService.findRoleByPage(limit,offset);
            Data<Role> roleData = new Data<>();
            roleData.setTotal(roles == null?0:roles.size());
            roleData.setItems(roles);
            return new ResponseVo(0,roleData,"成功");
        }else {
            List<Role> roles = roleService.findRoleByName(username);
            Data<Role> roleData = new Data<>();
            roleData.setTotal(roles == null?0:roles.size());
            roleData.setItems(roles);
            return new ResponseVo(0,roleData,"成功");
        }
    }
    @RequestMapping("create")
    @ResponseBody
    public ResponseVp create(@RequestBody Role role){
        boolean flag = roleService.addRole(role);
        if (flag) {
            return new ResponseVp(0,role,"成功");
        }else {
            return new ResponseVp(640,null,"角色已经存在");
        }
    }
    @RequestMapping("update")
    @ResponseBody
    public ResponseVp update(@RequestBody Role role){
        boolean flag = roleService.update(role);
        if(flag){
            return new ResponseVp(0,role,"成功");
        }else {
            return null;
        }
    }
    @RequestMapping("delete")
    @ResponseBody
    public ResponseVp delete(@RequestBody Role role){
        boolean flag = roleService.deleteRole(role);
        if(flag){
            return new ResponseVp(0,null,"成功");
        }else {
            return null;
        }
    }
}
