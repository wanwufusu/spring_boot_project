package com.springboot.controller.popularize;

import com.springboot.bean.popularize.MallGrouponRules;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.service.popularize.GrouponRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("groupon")
@RestController
public class GrouponRuleController {
    @Autowired
    GrouponRuleService service;

    @RequestMapping("list")
    public ResponseVO list(PageDetail pageDetail,Integer goodsId){
        return new ResponseVO(service.findList(pageDetail,goodsId),"成功",0);
    }

    @RequestMapping("create")
    public ResponseVO create(@RequestBody MallGrouponRules groupon){
        MallGrouponRules add = service.add(groupon);
        if (add != null){
            return new ResponseVO(add,"成功",0);
        }else return new ResponseVO(null,"失败",-1);
    }

    @RequestMapping("update")
    public ResponseVO update(@RequestBody MallGrouponRules groupon){
        MallGrouponRules update = service.update(groupon);
        if (update != null){
            return new ResponseVO(update,"成功",0);
        }else return new ResponseVO(null,"失败",-1);
    }

    @RequestMapping("delete")
    public ResponseVO delete(@RequestBody MallGrouponRules groupon){
        int i = service.delete(groupon);
        if (i>=1){
            return new ResponseVO(null,"成功",0);
        }else {
            return new ResponseVO(null,"失败",-1);
        }
    }
}
