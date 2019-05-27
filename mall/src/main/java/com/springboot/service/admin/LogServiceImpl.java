package com.springboot.service.admin;

import com.springboot.bean.admin.Log;
import com.springboot.mapper.admin.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;
    @Override
    public List<Log> findLogByPage(int limit, int offset) {
        List<Log> logs = logMapper.findLogByPage(limit,offset);
        return logs;
    }

    @Override
    public List<Log> findLogByName(String username,int limit,int offset) {
        List<Log> logs = logMapper.findLogByName(username,limit,offset);
        return logs;
    }
}
