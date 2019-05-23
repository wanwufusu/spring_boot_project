package com.springboot.controller.popularize;

import com.springboot.bean.ResponseMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdController {

    @RequestMapping("ad/list")
    @ResponseBody
    public ResponseMessage adList(){
        ResponseMessage responseMessage = new ResponseMessage(0,"成功","内容");
        return responseMessage;
    }
}
