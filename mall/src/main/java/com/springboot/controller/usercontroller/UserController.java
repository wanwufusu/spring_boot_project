package com.springboot.controller.usercontroller;


import com.alibaba.druid.sql.dialect.oracle.ast.clause.ModelClause;
import com.springboot.bean.user.User;
import com.springboot.bean.user.UserData;
import com.springboot.bean.user.UserPage;
import com.springboot.bean.user.UserResponseVO;

import com.springboot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("user/list")
    @ResponseBody
    public UserResponseVO getUserList(Model model, UserPage userPage,String username,String mobile){
        UserResponseVO<UserData> responseVO = new UserResponseVO<>();
        int offset = (userPage.getPage()-1)*userPage.getLimit();
        userPage.setOffset(offset);
        List<User> list=null;
        if(username==null&&mobile==null){
             list = userService.queryUser(userPage);
        }else if(username==null&&mobile!=null){
            list = userService.queryUserByMobile(mobile,userPage);
        }else{
            list = userService.queryUserByUsername(username,userPage);
        }

        int count = userService.findCount();
        UserData<User> userUserData = new UserData<User>(count,list);
        if(list!=null){
            responseVO.setErrno(0);
            responseVO.setData(userUserData);
            responseVO.setErrmsg("成功");
        }else{
            responseVO.setErrno(1);
            responseVO.setData(userUserData);
            responseVO.setErrmsg("失败");
        }
        return responseVO;

    }

}
