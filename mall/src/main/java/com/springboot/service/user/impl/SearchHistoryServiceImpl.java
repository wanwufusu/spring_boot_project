package com.springboot.service.user.impl;

import com.springboot.bean.user.SearchHistory;
import com.springboot.bean.user.UserPage;
import com.springboot.mapper.user.SearchHistoryMapper;
import com.springboot.service.user.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {
    @Autowired
    SearchHistoryMapper searchHistoryMapper;

    @Override
    public List<SearchHistory> querySearchHistory(UserPage userPage,String userid,String keyword) {
        int limit = userPage.getLimit();
        int offset = userPage.getOffset();
        String order = userPage.getOrder();
        String sort = userPage.getSort();
        if(userid==null&&keyword==null) {
            return searchHistoryMapper.QuerySearchHistoryByPage(offset, limit, sort, order);
        }else if(userid==null&&keyword!=null){
            return searchHistoryMapper.QuerySearchHistoryBykeyword(offset, limit, sort, order, keyword);
        }else if(userid!=null&&keyword==null){
            return searchHistoryMapper.QuerySearchHistoryByUserid(offset, limit, sort, order, userid);
        }else{
            return searchHistoryMapper.QuerySearchHistoryByUseridAndkeyword(offset, limit, sort, order, userid,keyword);
        }
    }

    @Override
    public int findCount() {
        return searchHistoryMapper.findCount();
    }
}
