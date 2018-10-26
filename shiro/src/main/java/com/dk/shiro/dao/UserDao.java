package com.dk.shiro.dao;

import com.dk.shiro.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @autor daikai
 * @Date 2018/10/23
 */
public interface UserDao extends JpaRepository<User,Long> {

    public User findByName(String name);
}
