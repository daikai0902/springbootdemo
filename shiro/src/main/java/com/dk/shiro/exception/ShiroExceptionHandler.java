package com.dk.shiro.exception;


import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * @autor daikai
 * @Date 2018/10/24
 */
@RestControllerAdvice
public class ShiroExceptionHandler  {


    @ExceptionHandler({AuthorizationException.class})
    @ResponseBody
    public String handlersException(AuthorizationException e){
        return e.getMessage();
    }



}
