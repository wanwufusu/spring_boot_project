package com.springboot.controller;


import com.springboot.bean.util.ResponseVO;
import com.springboot.service.MallConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MallSystemConfigController {

    @Autowired
    MallConfigService service;

    @RequestMapping("admin/config/mall")
    public ResponseVO mall() {
        return null;
    }

    @RequestMapping("admin/config/express")
    public ResponseVO express() {
        return null;
    }

    @RequestMapping("admin/config/order")
    public ResponseVO order() {
        return null;
    }

    @RequestMapping("admin/config/wx")
    public ResponseVO wx() {
        return null;
    }
}
