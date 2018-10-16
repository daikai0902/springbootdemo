package com.dk.redis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @autor kevin.dai
 * @Date 2018/9/30
 */
@Component
public class RedisUtils {


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    public Object get(String key){
       return redisTemplate.opsForValue().get(key);
    }


    public boolean set(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
        return true;
    }











}
