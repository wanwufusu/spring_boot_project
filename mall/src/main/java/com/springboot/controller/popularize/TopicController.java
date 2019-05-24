package com.springboot.controller.popularize;

import com.springboot.bean.popularize.MallTopic;
import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;
import com.springboot.service.popularize.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    TopicService service;

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO topiclist(PageDetail pageDetail){
        Result result = service.findlist(pageDetail);
        ResponseVO vo = new ResponseVO(result, "成功", 0);
        return vo;
    }

    @RequestMapping("create")
    public ResponseVO create(@RequestBody MallTopic topic){
        MallTopic add = service.add(topic);
        if (add != null){
            return new ResponseVO(add,"成功",0);
        }else return new ResponseVO(null,"失败",-1);
    }

    @RequestMapping("update")
    public ResponseVO update(@RequestBody MallTopic topic){
        MallTopic update = service.update(topic);
        if (update != null){
            return new ResponseVO(update,"成功",0);
        }else return new ResponseVO(null,"失败",-1);
    }

    @RequestMapping("delete")
    public ResponseVO delete(@RequestBody MallTopic topic){
        int i = service.delete(topic);
        if (i>=1){
            return new ResponseVO(null,"成功",0);
        }else {
            return new ResponseVO(null,"失败",-1);
        }
    }
}