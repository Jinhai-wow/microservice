package com.jinhai.microservice.rabbitmqconsumer.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

/**
 * @ClassName MessageConsumer
 * @Author Jinhai
 * @Date 2020/10/21 12:10
 * @Version 1.0
 */
@Component
@Slf4j
public class MessageConsumer implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        byte[] body = message.getBody();

        try {
            //批量手动确认消息
            channel.basicAck(deliveryTag,true);
            log.info("消息接收成功，{}",new String(body, Charset.forName("UTF-8")));
        } catch (Exception e){
            //拒绝消息后重新进队列等待被消费
            channel.basicReject(deliveryTag,true);
            log.error("消息接收失败，{}，原因：{}",new String(body, Charset.forName("UTF-8")),e.getMessage());
        }
    }
}
