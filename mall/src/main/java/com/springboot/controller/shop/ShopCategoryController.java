package com.springboot.controller.shop;

import com.springboot.bean.shop.CategoryName;
import com.springboot.bean.shop.MallCategory;
import com.springboot.bean.util.ResponseVO;
import com.springboot.service.shop.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("create")
    public ResponseVO<MallCategory> insertMallCategory(@RequestBody @Validated MallCategory mallCategory,
                                                       BindingResult bindingResult){
        ResponseVO<MallCategory> responseVO = new ResponseVO<>();
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String defaultMessage = fieldError.getDefaultMessage();
            responseVO.setErrmsg(defaultMessage);
            responseVO.setErrno(402);
        }
        else {
            int i = shopCategoryService.insertCategory(mallCategory);
            if (i > 0) {
                responseVO.setData(mallCategory);
                responseVO.setSuccessMsg();
            }
        }
        return responseVO;
    }

    @RequestMapping("delete")
    public ResponseVO<MallCategory> deleted(@RequestBody MallCategory mallCategory){
        shopCategoryService.deleteCategoryById(mallCategory.getId());
        ResponseVO<MallCategory> responseVO = new ResponseVO<>();
        responseVO.setSuccessMsg();
        return responseVO;
    }

    @RequestMapping("update")
    public ResponseVO<MallCategory> updateCategory(@RequestBody MallCategory mallCategory){
        int i = shopCategoryService.update(mallCategory);
        ResponseVO<MallCategory> responseVO = new ResponseVO<>();
        if (i > 0) {
            responseVO.setSuccessMsg();
            responseVO.setData(mallCategory);
        } else {
            responseVO.setErrno(-1);
            responseVO.setErrmsg("失败");
        }
        return responseVO;
    }

}
