package com.jinhai.microservice.rabbitmqprovider.controller;

import com.jinhai.microservice.rabbitmqprovider.provider.MessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName GxQxfwjkController
 * @Author Jinhai
 * @Date 2020/10/20 16:49
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/rabbitProvider")
@Slf4j
public class RabbitProviderController {
    @Autowired
    private MessageProvider messageProvider;

    @GetMapping("/send")
    public Boolean send(@RequestParam("message") String message){
        Boolean b = true;
        try {
            messageProvider.sendMessage(message);
        }catch (Exception e){
            b = false;
            log.error("发送消息失败，原因：{}",e.getMessage());
        }
        return b;
    }
}
