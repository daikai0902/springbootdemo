package com.dk.redis.controller;

import com.dk.core.result.Rs;
import com.dk.redis.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autor kevin.dai
 * @Date 2018/9/29
 */
@RestController
@RequestMapping("/redis")
public class TestController {


    @Autowired
    RedisUtils redisUtils;

    @GetMapping("/t")
    public Rs test(){
        String value = (String) redisUtils.get("name");
        Rs rs = new Rs(2000,value);
        return rs;
    }


}
