package com.springboot.service.shop.impl;

import com.springboot.bean.shop.CategoryName;
import com.springboot.bean.shop.MallCategory;
import com.springboot.mapper.shop.MallCategoryMapper;
import com.springboot.service.shop.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/23
 * @since 1.0.0
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    MallCategoryMapper mallCategoryMapper;

    @Override
    public List<MallCategory> queryAllCategorys() {
        return mallCategoryMapper.selectAllCategorys();
    }

    @Override
    public List<CategoryName> queryL1Categorys() {
        return mallCategoryMapper.selectL1Categorys();
    }

    @Override
    public int insertCategory(MallCategory mallCategory) {
        return mallCategoryMapper.insert(mallCategory);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        mallCategoryMapper.logicDeleteCategoryById(id);
    }

    @Override
    public int update(MallCategory mallCategory) {
        return mallCategoryMapper.updateByPrimaryKey(mallCategory);
    }
}
