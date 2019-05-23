package com.springboot.controller.popularize;

import com.springboot.bean.popularize.MallAd;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.service.popularize.ADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("ad")
public class ADController {

    @Autowired
    ADService service;

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO adList(PageDetail pageDetail){
        ResponseVO response = new ResponseVO(service.findList(pageDetail), "内容", 0);
        return response;
    }

    @RequestMapping("create")
    @ResponseBody
    public ResponseVO create (@RequestBody MallAd ad){
        ResponseVO<Object> vo = new ResponseVO<>();
        int i = service.add(ad);
        if (i>=1){
            vo.setSuccessMsg();
            vo.setData(i);
            return vo;
        }else {
            return vo;
        }

    }

}
