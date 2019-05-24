package com.springboot.controller.popularize;

import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.service.popularize.ADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("ad")
public class AdController {

    @Autowired
    ADService adService;

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO adList(PageDetail pageDetail){
        ResponseVO response = new ResponseVO(adService.findList(pageDetail), "内容", 0);
        return response;
    }
}
