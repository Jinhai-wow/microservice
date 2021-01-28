package com.jinhai.microservice.rabbitmqprovider.provider;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName rabbitProvider
 * @Author Jinhai
 * @Date 2020/10/21 11:48
 * @Version 1.0
 */
@Component
@Slf4j
public class MessageProvider {

    @Value("${rabbit.log.queue}")
    public String RABBIT_LOG_QUEUE;

    @Value("${rabbit.log.exchange}")
    public String RABBIT_LOG_EXCHANGE;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(RABBIT_LOG_EXCHANGE, RABBIT_LOG_QUEUE, message.getBytes());
    }
}
