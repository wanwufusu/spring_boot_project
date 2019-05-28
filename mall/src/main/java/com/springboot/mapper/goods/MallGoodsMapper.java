package com.springboot.mapper.goods;

import com.springboot.bean.goods.MallGoods;
import com.springboot.bean.util.PageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface MallGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallGoods record);

    int insertSelective(MallGoods record);

    MallGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MallGoods record);

    int updateByPrimaryKeyWithBLOBs(MallGoods record);

    int updateByPrimaryKey(MallGoods record);

    List<MallGoods> selectByPageDetailAndConditions(@Param("pageDetail")PageDetail pageDetail,
                                                    @Param("conditions")HashMap<String, Object> conditions);

    int selectAllRecordsByConditions(@Param("conditions")HashMap<String, Object> conditions);
}