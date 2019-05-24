package com.springboot.service.user;

import com.springboot.bean.user.SearchHistory;
import com.springboot.bean.user.UserPage;

import java.util.List;

public interface SearchHistoryService {
    List<SearchHistory> querySearchHistory(UserPage userPage, String userid, String keyword);

    int findCount();
}
