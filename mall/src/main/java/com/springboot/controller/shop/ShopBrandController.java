package com.springboot.controller.shop;

import com.springboot.bean.PageDetail;
import com.springboot.bean.ResponseVO;
import com.springboot.bean.Result;
import com.springboot.bean.shop.MallBrand;
import com.springboot.service.shop.ShopBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseVO<Result<MallBrand>> selectPageBrand(PageDetail pageDetail){
        return shopBrandService.selectPageBrand(pageDetail);
    }

    @RequestMapping("create")
    public ResponseVO<MallBrand> creatBrand(@RequestBody MallBrand mallBrand, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String defaultMessage = fieldError.getDefaultMessage();
            String code = fieldError.getCode();
            ResponseVO<MallBrand> responseVO = new ResponseVO<>();
            responseVO.setErrmsg(defaultMessage);
            responseVO.setErrno(Integer.parseInt(code));
            return responseVO;
        }
        else return null;
    }


}
