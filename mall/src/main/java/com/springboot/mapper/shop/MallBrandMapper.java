package com.springboot.mapper.shop;

import com.springboot.bean.util.PageDetail;
import com.springboot.bean.shop.MallBrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MallBrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallBrand record);

    int insertSelective(MallBrand record);

    MallBrand selectByPrimaryKey(Integer id);

    List<MallBrand>selectByPageDetail(@Param("pageDetail")PageDetail pageDetail);

    int selectAllRecords();

    int updateByPrimaryKeySelective(MallBrand record);

    int updateByPrimaryKey(MallBrand record);

    List<MallBrand> selectByPageDetailAndConditions(@Param("pageDetail")PageDetail pageDetail,
                                                    @Param("conditions")Map conditions);

    int selectAllRecordsByConditions(@Param("conditions")Map conditions);

    void logicDeleteBrandById(Integer id);
}