package com.dk.shiro.domain;

import com.dk.core.domain.BaseModel;

import javax.persistence.*;
import java.util.List;

/**
 * @autor daikai
 * @Date 2018/10/23
 */
@Entity
@Table(name = "shiro_role")
public class Role extends BaseModel {

    private String name;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Permission> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
