package com.springboot.controller.admin;

import com.springboot.bean.admin.Data;
import com.springboot.bean.admin.ResponseVo;
import com.springboot.bean.admin.ResponseVp;
import com.springboot.bean.admin.Storage;
import com.springboot.service.admin.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("storage")
public class StorageController {
    @Autowired
    StorageService storageService;
    @RequestMapping("list")
    @ResponseBody
    public ResponseVo list(int page,int limit,String key,String name){
        int offset = (page - 1) * limit;
        if(key == null && name == null){
            List<Storage> storages = storageService.findStorageByPage(limit,offset);
            Data<Storage> storageData = new Data<>();
            storageData.setTotal(storages == null?0:storages.size());
            storageData.setItems(storages);
            return new ResponseVo(0,storageData,"成功");
        }else if(key != null && name == null){
            List<Storage> storages = storageService.findStorageByKey(key,limit,offset);
            Data<Storage> storageData = new Data<>();
            storageData.setTotal(storages == null?0:storages.size());
            storageData.setItems(storages);
            return new ResponseVo(0,storageData,"成功");
        }else if(key == null && name != null){
            List<Storage> storages = storageService.findStorageByName(name,limit,offset);
            Data<Storage> storageData = new Data<>();
            storageData.setTotal(storages == null?0:storages.size());
            storageData.setItems(storages);
            return new ResponseVo(0,storageData,"成功");
        }else{
            List<Storage> storages = storageService.findStorageByKeyAndName(key,name,limit,offset);
            Data<Storage> storageData = new Data<>();
            storageData.setTotal(storages == null?0:storages.size());
            storageData.setItems(storages);
            return new ResponseVo(0,storageData,"成功");
        }
    }
    /*@RequestMapping("create")
    @ResponseBody
    public ResponseVp create(@RequestBody Storage storage){
        boolean flag = storageService.addStorage(storage);
        if(flag){
            return new ResponseVp(0,storage,"成功");
        }else {
            return new ResponseVp(0,null,"对象已存在");
        }
    }*/
}
