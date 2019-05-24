package com.springboot.controller.usercontroller;

import com.springboot.bean.user.*;
import com.springboot.service.user.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchHistoryController {
    @Autowired
    SearchHistoryService searchHistoryService;

    @RequestMapping("history/list")
    @ResponseBody
    public UserResponseVO getAddressList(Model model, UserPage userPage, String userId, String keyword){
        UserResponseVO<UserData> responseVO = new UserResponseVO<>();
        int offset = (userPage.getPage()-1)*userPage.getLimit();
        userPage.setOffset(offset);
        List<SearchHistory> list= searchHistoryService.querySearchHistory(userPage,userId,keyword);
        int count = searchHistoryService.findCount();
        UserData<SearchHistory> addressUserData = new UserData<>(count,list);
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
