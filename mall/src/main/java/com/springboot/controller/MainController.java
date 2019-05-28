package com.springboot.controller;

import com.springboot.bean.MallStorage;
import com.springboot.bean.admin.Admin;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.UpLoadUtil;
import com.springboot.service.MainService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    MainService mainService;

    @RequestMapping("hello")
    public String testHello(){
        return "hello";
    }

    /**
     * 用subject.login()登录
     *
     * @return
     */
    @RequestMapping(value = "auth/login")
    public ResponseVO login(@RequestBody Admin admin) {
/*        HashMap<String, Object> loginResult = new HashMap<>();
        //loginResult.put("data", "2fcc8519-2447-427a-ba05-c7d84bd36c32");
        loginResult.put("errmsg", "成功");
        loginResult.put("errno", 0);
        return loginResult;*/
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(admin.getUsername(), admin.getPassword());
        try {
            subject.login(token);
            return new ResponseVO<>(token, "登录成功", 0);
        } catch (Exception e) {
            return new ResponseVO(null, "用户名或密码错误", -1);
        }
    }


    /**
     * 该死的前端
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "auth/info")
    public Map loginInfo(UsernamePasswordToken token){

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
    public ResponseVO dashBoard(){
        return new ResponseVO("暂时没有东西", "空", 0);
    }

    @RequestMapping("storage/create")
    public ResponseVO<MallStorage> upload(MultipartFile file, HttpServletRequest request, MallStorage mallStorage){
        ResponseVO<MallStorage> responseVO = new ResponseVO<>();
        try {
            UpLoadUtil.upload(file, request, mallStorage);
            mainService.insertStorage(mallStorage);
            responseVO.setSuccessMsg();
            responseVO.setData(mallStorage);
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setErrmsg("失败");
            responseVO.setErrno(999);
        }

        return responseVO;
    }
}
