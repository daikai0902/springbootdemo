package com.dk.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @autor kevin.dai
 * @Date 2018/10/9
 */
public interface BaseDao<T> extends JpaRepository<T,Long> {

    /**
     * 根据名字查找
     * @Date: 10:21 2018/10/9
     */
    T findByName(String name);


    /**
     * 逻辑删除
     * @Date: 10:55 2018/10/9
     */
    Boolean logicDelete();






}
