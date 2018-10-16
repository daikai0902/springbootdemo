package com.dk.multisource.controller;

import com.dk.multisource.domain.User;
import com.dk.multisource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autor kevin.dai
 * @Date 2018/10/15
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/t1")
    public String test(){
        User user = userService.testu();
        if(user != null)
            return user.toString();
        else
            return "empty";
    }


    @GetMapping("/t2")
    public String master(){
        User user = userService.masteru();
        if(user != null)
            return user.toString();
        else
            return "empty";
    }
}
