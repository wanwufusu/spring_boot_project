package com.springboot.controller;


import com.springboot.bean.MallSystem;
import com.springboot.bean.util.ResponseVO;
import com.springboot.service.MallConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
public class MallSystemConfigController {

    @Autowired
    MallConfigService service;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 4个配置通用（which无实际意义，仅用于接收），返回ResponseVO，Data里面装KEY-VALUE(来自于数据库的key_name,key_value两个Column)
     *
     * @param which
     * @return
     */
    @RequestMapping(value = "config/{which}", method = RequestMethod.GET)
    public ResponseVO mallGet(@PathVariable("which") String which) {

        return null;
    }


    //——————————————————————————————————————————————————————————————————

    /**
     * 前台接收KEY-VALUE的信息，4个配置通用，返回ResponseVO，Data里面装KEY-VALUE
     *
     * @param map
     * @param which
     * @return
     */
    @RequestMapping(value = "config/{which}", method = RequestMethod.POST)
    public ResponseVO mallPost(@RequestBody HashMap<String, String> map, @PathVariable("which") String which) {

        return null;
    }

}
