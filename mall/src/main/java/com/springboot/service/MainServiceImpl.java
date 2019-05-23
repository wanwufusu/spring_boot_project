package com.springboot.service;

import com.springboot.bean.MallStorage;
import com.springboot.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/22
 * @since 1.0.0
 */
@Service
public class MainServiceImpl implements MainService {

    @Autowired
    MainMapper mainMapper;

    @Override
    public void insertStorage(MallStorage mallStorage) {
        mainMapper.insertStorage(mallStorage);
    }
}
