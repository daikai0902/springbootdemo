package com.dk.multisource.service;

import com.dk.multisource.dao.UserRepository;
import com.dk.multisource.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @autor kevin.dai
 * @Date 2018/10/15
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User testu(){
        return userRepository.testu();
    }


    public User masteru(){
        return userRepository.masteru();
    }
}
