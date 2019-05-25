package com.springboot.service.admin;

import com.springboot.bean.admin.Log;

import java.util.List;

public interface LogService {
    List<Log> findLogByPage(int limit, int offset);

    List<Log> findLogByName(String username,int limit,int offset);
}
