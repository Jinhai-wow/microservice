package com.jinhai.microservice.rabbitmqprovider.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitConfig
 * @Author Jinhai
 * @Date 2020/10/21 11:04
 * @Version 1.0
 */
@Configuration
@Slf4j
public class RabbitConfig {
    @Value("${rabbit.log.queue}")
    public String RABBIT_LOG_QUEUE;

    @Value("${rabbit.log.exchange}")
    public String RABBIT_LOG_EXCHANGE;

    @Autowired
    public CachingConnectionFactory cachingConnectionFactory;

    @Bean
    public Queue logQueue(){
        return new Queue(RABBIT_LOG_QUEUE);
    }

    @Bean
    public TopicExchange logExchange(){
        return new TopicExchange(RABBIT_LOG_EXCHANGE);
    }

    @Bean
    public Binding logBinding(Queue logQueue,TopicExchange logExchange){
        return BindingBuilder.bind(logQueue).to(logExchange).with(RABBIT_LOG_QUEUE);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);

        rabbitTemplate.setReturnCallback((message, replyCode, replyText, tmpExchange, tmpRoutingKey) -> {
            log.warn("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}", tmpExchange, tmpRoutingKey, replyCode, replyText, message);
        });
        rabbitTemplate.setConfirmCallback((CorrelationData correlationData, boolean success, String cause) -> {
            if (success) {
                log.info("消息发送成功:correlationData({}),ack({}),cause({})", correlationData, success, cause);
            }
        });

        return rabbitTemplate;
    }
}
