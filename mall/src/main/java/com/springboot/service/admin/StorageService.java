package com.springboot.service.admin;

import com.springboot.bean.admin.Storage;

import java.util.List;

public interface StorageService {
    List<Storage> findStorageByPage(int limit, int offset);

    List<Storage> findStorageByKey(String key, int limit, int offset);

    List<Storage> findStorageByName(String name, int limit, int offset);

    List<Storage> findStorageByKeyAndName(String key, String name, int limit, int offset);

    boolean addStorage(Storage storage);
}
