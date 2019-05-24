package com.springboot.controller.usercontroller;

import com.springboot.bean.user.Footprint;
import com.springboot.bean.user.UserData;
import com.springboot.bean.user.UserPage;
import com.springboot.bean.user.UserResponseVO;
import com.springboot.service.user.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FootprintController {
    @Autowired
    FootprintService footprintService;
    @RequestMapping("footprint/list")
    @ResponseBody
    public UserResponseVO getFootprintList(Model model, UserPage userPage, String userId, String goodsId){
        UserResponseVO<UserData> responseVO = new UserResponseVO<>();
        int offset = (userPage.getPage()-1)*userPage.getLimit();
        userPage.setOffset(offset);
        List<Footprint> list= footprintService.queryFootprint(userPage,userId,goodsId);
        int count = footprintService.findCount();
        UserData<Footprint> addressUserData = new UserData<Footprint>(count,list);
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
