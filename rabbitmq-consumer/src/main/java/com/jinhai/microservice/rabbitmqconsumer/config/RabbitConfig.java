package com.jinhai.microservice.rabbitmqconsumer.config;

import com.jinhai.microservice.rabbitmqconsumer.consumer.MessageConsumer;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitConfig
 * @Author Jinhai
 * @Date 2020/10/21 11:57
 * @Version 1.0
 */
@Configuration
public class RabbitConfig {
    @Value("${rabbit.log.queue}")
    public String RABBIT_LOG_QUEUE;

    @Value("${rabbit.log.exchange}")
    public String RABBIT_LOG_EXCHANGE;

    /**
     *  Queue每次给每个消费者发送消息条数；消费者处理完这些消息后Queue会再给该消费者发送一条消息
     **/
    @Value("${rabbit.log.prefetch-count}")
    private int prefetchCount;

    /**
     *  消费者线程数量
     **/
    @Value("${rabbit.log.concurrent-consumers}")
    private int concurrentConsumers;

    @Autowired
    public MessageConsumer messageConsumer;

    @Autowired
    public CachingConnectionFactory cachingConnectionFactory;

    @Bean
    public Binding blBinding() {
        Queue blQueue = new Queue(RABBIT_LOG_QUEUE);
        TopicExchange blExchange = new TopicExchange(RABBIT_LOG_EXCHANGE);
        return BindingBuilder.bind(blQueue).to(blExchange).with(RABBIT_LOG_QUEUE);
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(){
        SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer(cachingConnectionFactory);
        messageListenerContainer.setPrefetchCount(prefetchCount);
        messageListenerContainer.setConcurrentConsumers(concurrentConsumers);

        Queue blQueue = new Queue(RABBIT_LOG_QUEUE);
        messageListenerContainer.setQueues(blQueue);

        messageListenerContainer.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        messageListenerContainer.setMessageListener(messageConsumer);

        return messageListenerContainer;
    }
}
