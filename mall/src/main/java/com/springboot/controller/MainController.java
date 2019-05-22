package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {
    @RequestMapping("hello")
    public String testHello(){
        return "hello";
    }

    @RequestMapping(value = "auth/login", method = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST})
    public Map login(String username, String password){
        HashMap<String, Object> loginResult = new HashMap<>();
        loginResult.put("data", "123456");
        loginResult.put("errmsg", "成功");
        loginResult.put("errno", 0);
        return loginResult;
    }

    @RequestMapping(value = "auth/info", method = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST})
    public Map loginInfo(){
        HashMap<String, Object> loginToken = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("avatar", "1234");
        data.put("name", "admin123");
        data.put("roles", new String[]{"超级管理员"});
        loginToken.put("data", data);
        loginToken.put("errmsg", "成功");
        loginToken.put("errno", 0);
        return loginToken;

    }
}
