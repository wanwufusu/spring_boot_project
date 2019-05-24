package com.springboot.mapper.user;

import com.springboot.bean.user.SearchHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchHistoryMapper {
    List<SearchHistory> QuerySearchHistoryByPage(@Param("offset") int offset, @Param("limit") int limit,
                                                 @Param("sort")String sort, @Param("order")String order
    );

    int findCount();

    List<SearchHistory> QuerySearchHistoryBykeyword(@Param("offset") int offset, @Param("limit") int limit,
                                     @Param("sort")String sort, @Param("order")String order,
                                     @Param("keyword")String keyword);

    List<SearchHistory> QuerySearchHistoryByUserid(@Param("offset") int offset, @Param("limit") int limit,
                                       @Param("sort")String sort, @Param("order")String order,
                                       @Param("userid")String userid);

    List<SearchHistory> QuerySearchHistoryByUseridAndkeyword(@Param("offset") int offset, @Param("limit") int limit,
                                              @Param("sort")String sort, @Param("order")String order,
                                              @Param("userid")String userid,@Param("keyword")String keyword);
}
