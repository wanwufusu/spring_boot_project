package com.springboot.service.shop;

import com.springboot.bean.shop.CategoryName;
import com.springboot.bean.shop.MallCategory;

import java.util.List;

public interface ShopCategoryService {
    List<MallCategory> queryAllCategorys();

    List<CategoryName> queryL1Categorys();
}
