package com.springboot.controller.shop;

import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;
import com.springboot.bean.shop.MallBrand;
import com.springboot.service.shop.ShopBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/23
 * @since 1.0.0
 */
@RestController
@RequestMapping("brand")
public class ShopBrandController {

    @Autowired
    ShopBrandService shopBrandService;

    /**
     * 查找页面品牌
     * @param pageDetail
     * @return
     */
    @RequestMapping("list")
    public ResponseVO<Result<MallBrand>> selectPageBrand(PageDetail pageDetail, String id, String name){
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("id", id);
        conditions.put("name", name);
        return shopBrandService.selectPageBrandByConditions(pageDetail, conditions);
    }

    @RequestMapping("create")
    public ResponseVO<MallBrand> creatBrand(@RequestBody @Validated MallBrand mallBrand, BindingResult bindingResult){

        ResponseVO<MallBrand> responseVO = new ResponseVO<>();
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String defaultMessage = fieldError.getDefaultMessage();
            responseVO.setErrmsg(defaultMessage);
            responseVO.setErrno(402);
        }
        else {
            int i = shopBrandService.insertBrand(mallBrand);
            if (i > 0) {
                responseVO.setData(mallBrand);
                responseVO.setSuccessMsg();
            }
        }
        return responseVO;
    }

    @RequestMapping("delete")
    public ResponseVO<MallBrand> deleted(@RequestBody MallBrand mallBrand){
        shopBrandService.deleteBrandById(mallBrand.getId());
        ResponseVO<MallBrand> responseVO = new ResponseVO<>();
        responseVO.setSuccessMsg();
        return responseVO;
    }

    @RequestMapping("update")
    public ResponseVO<MallBrand> updateBrand(@RequestBody MallBrand mallBrand){
        int i = shopBrandService.update(mallBrand);
        ResponseVO<MallBrand> responseVO = new ResponseVO<>();
        if (i > 0) {
            responseVO.setSuccessMsg();
            responseVO.setData(mallBrand);
        } else {
            responseVO.setErrno(999);
            responseVO.setErrmsg("失败");
        }
        return responseVO;
    }
}
