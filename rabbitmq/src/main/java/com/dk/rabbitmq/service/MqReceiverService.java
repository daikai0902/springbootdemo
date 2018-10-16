package com.dk.rabbitmq.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 消息接收服务
 * @autor kevin.dai
 * @Date 2018/10/9
 */
@Service
public class MqReceiverService {

    @RabbitListener(queues = {"direct_queue"})
    public void message(Message message, Channel channel) throws IOException {
        //channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        System.err.println("~~~~~"+new String(message.getBody()));
    }



}
