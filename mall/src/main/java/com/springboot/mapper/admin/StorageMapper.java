package com.springboot.mapper.admin;

import com.springboot.bean.admin.Storage;
import com.springboot.bean.admin.StorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper {
    long countByExample(StorageExample example);

    int deleteByExample(StorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    int insertSelective(Storage record);

    List<Storage> selectByExample(StorageExample example);

    Storage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByExample(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

    List<Storage> findStorageByPage(@Param("rows") int rows, @Param("offset") int offset);

    List<Storage> findStorageByKey(@Param("key") String key, @Param("rows") int rows, @Param("offset") int offset);

    List<Storage> findStorageByName(@Param("name") String name, @Param("rows") int rows, @Param("offset") int offset);

    List<Storage> findStorageByKeyAndName(@Param("key") String key,@Param("name") String name, @Param("rows") int rows, @Param("offset") int offset);
}