package com.dk.rabbitmq;

import com.dk.rabbitmq.service.MqSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @autor kevin.dai
 * @Date 2018/10/9
 */
@Component
public class StartUp implements CommandLineRunner {

    @Autowired
    private MqSenderService senderService;

    @Override
    public void run(String... args) {
        System.err.println("=====start=========");
        senderService.direct("sss,daikai");
    }
}
