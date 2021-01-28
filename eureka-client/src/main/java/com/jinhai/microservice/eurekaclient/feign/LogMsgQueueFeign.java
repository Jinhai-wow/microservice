package com.jinhai.microservice.eurekaclient.feign;

import com.baomidou.mybatisplus.extension.api.R;
import com.jinhai.microservice.commoncore.entity.gx.GxQxfwjk;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName GxQxfwjkFeign
 * @Author Jinhai
 * @Date 2020/10/20 17:39
 * @Version 1.0
 */
@Component
@FeignClient(value = "rabbitmq-provider")
public interface LogMsgQueueFeign {
    /**
     *  feign调用rabbitMq生成者服务
     * @Author Jinhai
     * @param message
     * @Date 15:27 2020/10/23
     * @return java.lang.Boolean
     * @Exception 
     **/
    @GetMapping("/rabbitProvider/send")
    Boolean send(@RequestParam("message") String message);
}
