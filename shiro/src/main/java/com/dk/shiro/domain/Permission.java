package com.dk.shiro.domain;

import com.dk.core.domain.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @autor daikai
 * @Date 2018/10/23
 */
@Entity
@Table(name = "shiro_permission")
public class Permission extends BaseModel {

    private String name;

    private String permissionUrl;

    private String method;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
