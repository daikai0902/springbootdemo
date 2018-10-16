package com.dk.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @autor kevin.dai
 * @Date 2018/7/19
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue helloqueue(){
        return new Queue("hello",false);//false表示不支持持久化
    }


    @Bean
    public Exchange helloExchange(){
        return new DirectExchange("helloExchange");
    }


    //#######################  direct类型交换器 （route_key完全匹配再转发）  #####################

    @Bean
    public Queue directQueue(){
        return QueueBuilder.durable("direct_queue").build();//durable表示支持持久化
    }


    @Bean
    public Exchange directExchange(){
        return ExchangeBuilder.directExchange("direct_exchange").durable(true).build();
    }


    @Bean
    public Binding directBinding(){
        return BindingBuilder.bind(directQueue()).to(directExchange())
                .with("direct_route_key").noargs();//指定路由键
    }


    //#######################  fanout类型交换器 （转发消息到所有绑定队列）  #####################

    @Bean("fanoutQueueA")
    public Queue fanoutQueueA() {
        return QueueBuilder.durable("fanout_queue_a").build();
    }



    @Bean("fanoutQueueB")
    public Queue fanoutQueueB() {
        return QueueBuilder.durable("fanout_queue_b").build();
    }



    @Bean("fanoutExchange")
    public FanoutExchange fanoutExchange() {
        return (FanoutExchange) ExchangeBuilder.fanoutExchange("fanout_exchange").durable(true).build();
    }


    @Bean
    public Binding bindingA() {
        return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
    }



    @Bean
    public Binding bindingB() {
        return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
    }
}
