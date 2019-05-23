package com.springboot.controller;

import com.springboot.bean.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {
    @RequestMapping("hello")
    public String testHello(){
        return "hello";
    }

    @RequestMapping(value = "auth/login")
    public Map login(String username, String password){
        HashMap<String, Object> loginResult = new HashMap<>();
        //loginResult.put("data", "2fcc8519-2447-427a-ba05-c7d84bd36c32");
        loginResult.put("errmsg", "成功");
        loginResult.put("errno", 0);
        return loginResult;
    }

    @RequestMapping(value = "auth/info")
    public Map loginInfo(){
        HashMap<String, Object> loginToken = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("*");
        ArrayList<String> strings2 = new ArrayList<>();
        strings2.add("超级管理员");

        data.put("name", "admin123");
        data.put("perms", strings);
        data.put("roles", strings2);
        loginToken.put("data", data);
        loginToken.put("errmsg", "成功");
        loginToken.put("errno", 0);
        return loginToken;
    }

    /**
     * 空的仪表盘，为了让它不报错
     * @return
     */
    @RequestMapping("dashboard")
    @ResponseBody
    public ResponseVO dashBoard(){
        return new ResponseVO("暂时没有东西", "空", 0);
    }
}
