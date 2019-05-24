package com.springboot.controller.shop;

import com.springboot.bean.shop.MallIssue;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;
import com.springboot.service.shop.ShopIssueService;
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
@RequestMapping("issue")
public class ShopIssueController {
    @Autowired
    ShopIssueService shopIssueService;

    @RequestMapping("list")
    public ResponseVO<Result<MallIssue>> selectPageIssue(PageDetail pageDetail, String question){
        HashMap<String, Object> conditions = new HashMap<>();
        conditions.put("question", question);
        ResponseVO<Result<MallIssue>> responseVO = new ResponseVO<>();
        Result<MallIssue> result =  shopIssueService.selectPageIssueByConditions(pageDetail, conditions);
        responseVO.setData(result);
        responseVO.setSuccessMsg();
        return responseVO;
    }

    @RequestMapping("create")
    public ResponseVO<MallIssue> creatIssue(@RequestBody @Validated MallIssue mallIssue, BindingResult bindingResult){

        ResponseVO<MallIssue> responseVO = new ResponseVO<>();
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String defaultMessage = fieldError.getDefaultMessage();
            responseVO.setErrmsg(defaultMessage);
            responseVO.setErrno(402);
        }
        else {
            int i = shopIssueService.insertIssue(mallIssue);
            if (i > 0) {
                responseVO.setData(mallIssue);
                responseVO.setSuccessMsg();
            }
        }
        return responseVO;
    }

    @RequestMapping("delete")
    public ResponseVO<MallIssue> deleted(@RequestBody MallIssue mallIssue){
        shopIssueService.deleteIssueById(mallIssue.getId());
        ResponseVO<MallIssue> responseVO = new ResponseVO<>();
        responseVO.setSuccessMsg();
        return responseVO;
    }

    @RequestMapping("update")
    public ResponseVO<MallIssue> updateIssue(@RequestBody MallIssue mallIssue){
        int i = shopIssueService.update(mallIssue);
        ResponseVO<MallIssue> responseVO = new ResponseVO<>();
        if (i > 0) {
            responseVO.setSuccessMsg();
            responseVO.setData(mallIssue);
        } else {
            responseVO.setErrno(-1);
            responseVO.setErrmsg("失败");
        }
        return responseVO;
    }
}
