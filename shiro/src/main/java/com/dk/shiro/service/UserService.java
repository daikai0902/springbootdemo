package com.dk.shiro.service;

import com.dk.shiro.dao.UserDao;
import com.dk.shiro.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @autor daikai
 * @Date 2018/10/23
 */
@Service
public class UserService {


    @Autowired
    UserDao userDao;


    public User findUserByName(String name){
        return userDao.findByName(name);
    }
}
