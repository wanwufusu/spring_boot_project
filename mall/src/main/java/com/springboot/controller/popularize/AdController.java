package com.springboot.controller.popularize;

import com.springboot.bean.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdController {

    @RequestMapping("ad/list")
    @ResponseBody
    public ResponseVO adList(){
        ResponseVO response = new ResponseVO("成功", "内容", 0);
        return response;
    }
}
