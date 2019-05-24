package com.springboot.controller.usercontroller;

import com.springboot.bean.user.Feedback;
import com.springboot.bean.user.UserData;
import com.springboot.bean.user.UserPage;
import com.springboot.bean.user.UserResponseVO;
import com.springboot.service.user.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @RequestMapping("feedback/list")
    @ResponseBody
    public UserResponseVO getfeedbackList(Model model, UserPage userPage, String id, String username){
        UserResponseVO<UserData> responseVO = new UserResponseVO<>();
        int offset = (userPage.getPage()-1)*userPage.getLimit();
        userPage.setOffset(offset);
        List<Feedback> list= feedbackService.queryFeedback(userPage,id,username);
        int count = feedbackService.findCount();
        UserData<Feedback> addressUserData = new UserData<>(count,list);
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
