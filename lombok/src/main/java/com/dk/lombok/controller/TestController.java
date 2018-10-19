package com.dk.lombok.controller;

import com.dk.lombok.domain.Student;
import com.dk.lombok.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autor kevin.dai
 * @Date 2018/10/18
 */
@RestController
@Slf4j
public class TestController {


    @GetMapping("/t")
    public String test(){
        log.info("这是日志");
        //以builder的方式初始化
        User user = User.builder().name("王嘉明").age(21).isAdmin(false).build();
        Student student = new Student();
        student.setName("小明");
        student.setNumber("201831232432");
        return user.toString();
    }






}
