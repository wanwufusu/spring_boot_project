package com.springboot.controller.admin;

import com.springboot.service.admin.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    LogService logService;

}
