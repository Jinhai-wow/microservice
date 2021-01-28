package com.jinhai.microservice.eurekaclient.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.jinhai.microservice.common.reids.utils.RedisUtils;
import com.jinhai.microservice.commoncore.utils.TraceIdUtil;
import com.jinhai.microservice.eurekaclient.feign.GxQxfwjkFeign;
import com.jinhai.microservice.eurekaclient.feign.LogMsgQueueFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @ClassName EurekaClientController
 * @Author Jinhai
 * @Date 2020/9/14 11:49
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/eurekaClient")
@CrossOrigin
@Api(value = "eurekaClient接口api",description = "")
public class EurekaClientController {

    @Autowired
    public GxQxfwjkFeign gxQxfwjkFeign;

    @Autowired
    @Qualifier("redisTemplate")
    public RedisTemplate redisUtils;

    @Autowired
    public LogMsgQueueFeign logMsgQueueFeign;

    @GetMapping(value = "/hello",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "测试接口",notes = "测试")
    @ApiImplicitParam(name = "hello", value = "测试", required = true, dataType = "String", paramType = "query")
    public Map<String,Object> hello(@RequestParam @Nullable String hello){
        Map<String,Object> map = new HashMap<>(10);
        map.put("hello","hello world");
        Set<String> set = redisUtils.keys("*");
        if(redisUtils.hasKey("user_details")){
            System.out.println(redisUtils.opsForValue().get("user_details"));
        }else if(redisUtils.hasKey("bdc")){
            System.out.println(redisUtils.opsForValue().get("bdc"));
        }
        return map;
    }

    @GetMapping("/getFeignData/{qxdm}")
    public R getFeignData(@PathVariable("qxdm") String qxdm){
        TraceIdUtil.setTraceId(UUID.randomUUID().toString());
        log.info("请求开始");
        R r = gxQxfwjkFeign.getData(qxdm);
        log.error("请求结束");
        //logMsgQueueFeign.send(r.toString());
        TraceIdUtil.clear();
        return new R();
    }

}
