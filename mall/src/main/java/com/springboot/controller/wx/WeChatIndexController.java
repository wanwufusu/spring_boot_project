package com.springboot.controller.wx;

import com.springboot.bean.util.PageDetail;
import com.springboot.bean.util.ResponseVO;
import com.springboot.bean.util.Result;
import com.springboot.bean.wx.WeChatIndex;
import com.springboot.service.wx.WeChatIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/27
 * @since 1.0.0
 */
@RestController
@RequestMapping("wx")
public class WeChatIndexController {
    @Autowired
    WeChatIndexService weChatIndexService;

    @RequestMapping("home/index")
    public ResponseVO<WeChatIndex> selectPageGoods(){
        HashMap<String, Object> conditions = new HashMap<>();
        ResponseVO<WeChatIndex> responseVO = new ResponseVO<>();
        WeChatIndex result =  weChatIndexService.selectIndexDetail();
        responseVO.setData(result);
        responseVO.setSuccessMsg();
        return responseVO;
    }
}
