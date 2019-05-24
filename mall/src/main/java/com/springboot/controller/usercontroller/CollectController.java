package com.springboot.controller.usercontroller;


import com.springboot.bean.user.Collect;
import com.springboot.bean.user.UserData;
import com.springboot.bean.user.UserPage;
import com.springboot.bean.user.UserResponseVO;
import com.springboot.service.user.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CollectController {
    @Autowired
    CollectService collectService;

    @RequestMapping("collect/list")
    @ResponseBody
    public UserResponseVO getAddressList(Model model, UserPage userPage, String userId, String valueId){
        UserResponseVO<UserData> responseVO = new UserResponseVO<>();
        int offset = (userPage.getPage()-1)*userPage.getLimit();
        userPage.setOffset(offset);
        List<Collect> list= collectService.queryCollect(userPage,userId,valueId);
        int count = collectService.findCount();
        UserData<Collect> addressUserData = new UserData<>(count,list);
        if(list!=null){
            responseVO.setErrno(0);
            responseVO.setData(addressUserData);
            responseVO.setErrmsg("成功");
        }else{
            responseVO.setErrno(502);
            responseVO.setData(addressUserData);
            responseVO.setErrmsg("系统内部错误");
        }
        return responseVO;
    }
}
