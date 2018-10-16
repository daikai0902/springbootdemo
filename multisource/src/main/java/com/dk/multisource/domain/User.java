package com.dk.multisource.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @autor kevin.dai
 * @Date 2018/10/15
 */
@Entity
@Table(name = "user")
public class User implements Serializable {


    private static final long serialVersionUID = 5417189132390873910L;


    @Id
    @GeneratedValue
    private Long id;


    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "user:"+getName()+"";
    }
}
