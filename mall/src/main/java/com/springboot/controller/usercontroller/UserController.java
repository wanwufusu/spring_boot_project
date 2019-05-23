package com.springboot.controller.usercontroller;


import com.alibaba.druid.sql.dialect.oracle.ast.clause.ModelClause;
import com.springboot.bean.user.User;
import com.springboot.bean.user.UserPage;
import com.springboot.bean.user.UserResponseVO;

import com.springboot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("admin/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("list")
    public UserResponseVO getUserList(Model model, UserPage userPage){
        UserResponseVO<User> responseVO = new UserResponseVO<>();
        int offset = (userPage.getPage()-1)*userPage.getLimit();
        userPage.setOffset(offset);
        List<User> list = userService.queryUser(userPage);
        if(list!=null){
            responseVO.setErrno(0);
            responseVO.setData(list);
            responseVO.setErrmsg("成功");
        }else{
            responseVO.setErrno(1);
            responseVO.setData(list);
            responseVO.setErrmsg("失败");
        }
        return responseVO;

    }

}
