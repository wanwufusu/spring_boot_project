package com.springboot.service.admin;

import com.springboot.bean.admin.Storage;
import com.springboot.mapper.admin.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageMapper storageMapper;

    @Override
    public List<Storage> findStorageByPage(int limit, int offset) {
        List<Storage> storages = storageMapper.findStorageByPage(limit,offset);
        return storages;
    }

    @Override
    public List<Storage> findStorageByKey(String key, int limit, int offset) {
        List<Storage> storages = storageMapper.findStorageByKey(key,limit,offset);
        return storages;
    }

    @Override
    public List<Storage> findStorageByName(String name, int limit, int offset) {
        List<Storage> storages = storageMapper.findStorageByName(name,limit,offset);
        return storages;
    }

    @Override
    public List<Storage> findStorageByKeyAndName(String key, String name, int limit, int offset) {
        List<Storage> storages = storageMapper.findStorageByKeyAndName(key,name,limit,offset);
        return storages;
    }

    @Override
    public boolean addStorage(Storage storage) {
        List<Storage> check = storageMapper.findStorageByKey(storage.getKey(),0,20);
        if(check == null){
            storageMapper.insertSelective(storage);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Storage storage) {
        int i = storageMapper.updateByPrimaryKeySelective(storage);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Storage storage) {
        int i = storageMapper.deleteByPrimaryKey(storage.getId());
        if(i > 0){
            return true;
        }
        return false;
    }
}
