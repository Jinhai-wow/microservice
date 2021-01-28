package com.jinhai.microservice.eurekaclient.feign;

import com.baomidou.mybatisplus.extension.api.R;
import com.jinhai.microservice.commoncore.entity.gx.GxQxfwjk;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName GxQxfwjkFeign
 * @Author Jinhai
 * @Date 2020/10/20 17:39
 * @Version 1.0
 */
@Component
@FeignClient(value = "eureka-client2")
public interface GxQxfwjkFeign {
    /**
     *  feign调用服务
     * @Author Jinhai
     * @param id
     * @Date 15:27 2020/10/23
     * @return com.baomidou.mybatisplus.extension.api.R<com.jinhai.microservice.commoncore.entity.gx.GxQxfwjk>
     * @Exception 
     **/
    @GetMapping(value = "/gxQxfwjk/getData")
    R<GxQxfwjk> getData(@RequestParam("id") String id);
}
