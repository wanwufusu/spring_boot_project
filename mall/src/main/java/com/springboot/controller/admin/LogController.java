package com.springboot.controller.admin;

import com.springboot.bean.admin.Data;
import com.springboot.bean.admin.Log;
import com.springboot.bean.admin.ResponseVo;
import com.springboot.service.admin.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    LogService logService;
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo list(int page,int limit,String username){
        int offset = (page - 1) * limit;
        if(username == null){
            List<Log> logs = logService.findLogByPage(limit,offset);
            Data<Log> logData = new Data<>();
            logData.setTotal(logs == null?0:logs.size());
            logData.setItems(logs);
            return new ResponseVo(0,logData,"成功");
        }else {
            List<Log> logs = logService.findLogByName(username,limit,offset);
            Data<Log> logData = new Data<>();
            logData.setItems(logs);
            logData.setTotal(logs == null?0:logs.size());
            return new ResponseVo(0,logData,"成功");
        }
    }
}
