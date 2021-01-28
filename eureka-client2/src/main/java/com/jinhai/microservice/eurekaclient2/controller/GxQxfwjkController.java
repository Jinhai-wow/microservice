package com.jinhai.microservice.eurekaclient2.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.jinhai.microservice.commoncore.entity.gx.GxQxfwjk;
import com.jinhai.microservice.eurekaclient2.service.IGxQxfwjkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GxQxfwjkController
 * @Author Jinhai
 * @Date 2020/10/20 16:49
 * @Version 1.0
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/gxQxfwjk")
public class GxQxfwjkController {
    @Autowired
    private IGxQxfwjkService iGxQxfwjkService;

    @GetMapping("/getData")
    public R<GxQxfwjk> getData(@RequestParam("id") String id, HttpServletRequest request){
        QueryWrapper wrapper = new QueryWrapper<GxQxfwjk>().eq("QXDM",id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new R<GxQxfwjk>().setData(iGxQxfwjkService.getOne(wrapper));
    }
}
