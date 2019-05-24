package com.springboot.controller.shop;

import com.springboot.bean.shop.MallKeyword;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;
import com.springboot.service.shop.ShopKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/24
 * @since 1.0.0
 */
@RestController
@RequestMapping("keyword")
public class ShopKeywordController {
    @Autowired
    ShopKeywordService shopKeywordService;

    @RequestMapping("list")
    public ResponseVO<Result<MallKeyword>> selectPageKeyword(PageDetail pageDetail, String keyword, String url){
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("keyword", keyword);
        conditions.put("url", url);
        ResponseVO<Result<MallKeyword>> responseVO = new ResponseVO<>();
        Result<MallKeyword> result =  shopKeywordService.selectPageKeywordByConditions(pageDetail, conditions);
        responseVO.setData(result);
        responseVO.setSuccessMsg();
        return responseVO;
    }

    @RequestMapping("create")
    public ResponseVO<MallKeyword> creatKeyword(@RequestBody @Validated MallKeyword mallKeyword, BindingResult bindingResult){

        ResponseVO<MallKeyword> responseVO = new ResponseVO<>();
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String defaultMessage = fieldError.getDefaultMessage();
            responseVO.setErrmsg(defaultMessage);
            responseVO.setErrno(402);
        }
        else {
            int i = shopKeywordService.insertKeyword(mallKeyword);
            if (i > 0) {
                responseVO.setData(mallKeyword);
                responseVO.setSuccessMsg();
            }
        }
        return responseVO;
    }

    @RequestMapping("delete")
    public ResponseVO<MallKeyword> deleted(@RequestBody MallKeyword mallKeyword){
        shopKeywordService.deleteKeywordById(mallKeyword.getId());
        ResponseVO<MallKeyword> responseVO = new ResponseVO<>();
        responseVO.setSuccessMsg();
        return responseVO;
    }

    @RequestMapping("update")
    public ResponseVO<MallKeyword> updateKeyword(@RequestBody MallKeyword mallKeyword){
        int i = shopKeywordService.update(mallKeyword);
        ResponseVO<MallKeyword> responseVO = new ResponseVO<>();
        if (i > 0) {
            responseVO.setSuccessMsg();
            responseVO.setData(mallKeyword);
        } else {
            responseVO.setErrno(-1);
            responseVO.setErrmsg("失败");
        }
        return responseVO;
    }

}
