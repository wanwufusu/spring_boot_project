package com.springboot.controller.admin;

import com.springboot.bean.admin.Data;
import com.springboot.bean.admin.ResponseVo;
import com.springboot.bean.admin.Role;
import com.springboot.bean.admin.RoleData;
import com.springboot.bean.util.ResponseVO;
import com.springboot.service.admin.RoleService;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            roleData.setItems(roles);
            roleData.setTotal(roles == null?0:roles.size());
            return new ResponseVo(0,roleData,"成功");
        }
    }
}
