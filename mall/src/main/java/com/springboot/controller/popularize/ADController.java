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
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("ad")
@RestController
public class ADController {
    @Autowired
    ADService service;

    @RequestMapping("list")
    public ResponseVO grouponList(PageDetail pageDetail,String name,String content){
        ResponseVO vo = new ResponseVO(service.findList(pageDetail,name,content), "成功", 0);
        return vo;
    }

    @RequestMapping("create")
    public ResponseVO create(@RequestBody MallAd ad){
        MallAd add = service.add(ad);
        if (add != null){
            return new ResponseVO(add,"成功",0);
        }else return new ResponseVO(null,"失败",-1);
    }

    @RequestMapping("update")
    public ResponseVO update(@RequestBody MallAd ad){
        MallAd update = service.update(ad);
        if (update != null){
            return new ResponseVO(update,"成功",0);
        }else return new ResponseVO(null,"失败",-1);
    }

    @RequestMapping("delete")
    public ResponseVO delete(@RequestBody MallAd ad){
        int i = service.delete(ad);
        if (i>=1){
            return new ResponseVO(null,"成功",0);
        }else {
            return new ResponseVO(null,"失败",-1);
        }
    }

}
