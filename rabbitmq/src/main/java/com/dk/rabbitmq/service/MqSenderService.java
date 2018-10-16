package com.dk.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * 消息发送
 * @autor kevin.dai
 * @Date 2018/10/9
 */
@Service
public class MqSenderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PostConstruct
    public void init(){
        System.err.println("sb");
    }


    public void direct(String msg){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("direct_exchange","direct_route_key",msg,correlationData);
    }




}
