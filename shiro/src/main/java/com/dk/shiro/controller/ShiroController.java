package com.dk.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @autor daikai
 * @Date 2018/10/23
 */
@Controller
public class ShiroController {


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @GetMapping("/403")
    public String uauth(){
        return "403";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/login1")
    @ResponseBody
    public String login(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken upt = new UsernamePasswordToken(username,password);
        try {
            subject.login(upt);
            //前后端分离项目在这里sessionId,扔给前端
            String sessionId = (String) subject.getSession().getId();
            System.err.println("sessionId:===="+sessionId);
            return "success";
        }catch (AuthenticationException e){
            return "no user";
        }


    }


    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @GetMapping("/c")
    @ResponseBody
    public String cretae(){
        try {
            return "create success";
        }catch (AuthorizationException e){
            System.err.println("ssssss");
            return "you have no auth";
        }

    }









}
