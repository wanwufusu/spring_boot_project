package com.springboot.controller.popularize;

import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.service.popularize.GrouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("groupon")
@Controller
public class GrouponController {
    @Autowired
    GrouponService service;

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO grouponList(PageDetail pageDetail){
        return new ResponseVO(service.findList(pageDetail),"成功",0);
    }
}
