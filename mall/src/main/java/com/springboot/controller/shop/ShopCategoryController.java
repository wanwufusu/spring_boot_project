package com.springboot.controller.shop;

import com.springboot.bean.shop.CategoryName;
import com.springboot.bean.shop.MallCategory;
import com.springboot.bean.util.ResponseVO;
import com.springboot.service.shop.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/23
 * @since 1.0.0
 */
@RestController
@RequestMapping("category")
public class ShopCategoryController {
    @Autowired
    ShopCategoryService shopCategoryService;

    @RequestMapping("list")
    public ResponseVO<List<MallCategory>> queryCategorys(){
        List<MallCategory> mallCategories = shopCategoryService.queryAllCategorys();
        return new ResponseVO<List<MallCategory>>(mallCategories, "成功", 0);
    }

    @RequestMapping("l1")
    public ResponseVO<List<CategoryName>> queryCategorysL1(){
        List<CategoryName> categoryNamesL1 = shopCategoryService.queryL1Categorys();
        return new ResponseVO<List<CategoryName>>(categoryNamesL1, "成功", 0);
    }

}
