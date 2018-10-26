package com.dk.shiro.domain;

import com.dk.core.domain.BaseModel;

import javax.persistence.*;
import java.util.List;

/**
 * @autor daikai
 * @Date 2018/10/23
 */
@Entity
@Table(name = "shiro_user")
public class User extends BaseModel {

    private String name;

    private String password;

    private int age;

    private String number;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Role> roles;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
