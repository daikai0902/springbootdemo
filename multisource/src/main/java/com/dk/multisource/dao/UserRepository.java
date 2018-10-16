package com.dk.multisource.dao;

import com.dk.multisource.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @autor kevin.dai
 * @Date 2018/10/15
 */
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User  u where u.id = 1 ")
    User testu();


    @Query("select u from User  u where u.id = 1 ")
    User masteru();
}
