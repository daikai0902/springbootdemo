package com.dk.shiro.shiro;

import com.dk.shiro.domain.Permission;
import com.dk.shiro.domain.Role;
import com.dk.shiro.domain.User;
import com.dk.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @autor daikai
 * @Date 2018/10/22
 */
public class ShiroRealm extends AuthorizingRealm {


    @Autowired
    UserService userService;

    /**
     * 授权
     * @Date: 13:51 2018/10/23
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.findUserByName(userName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for(Role role:user.getRoles()){
            info.addRole(role.getName());
            for(Permission permission:role.getPermissions()){
                info.addStringPermission(permission.getName());
            }
        }
        return info;
    }



    /**
     * 用户认证
     * @Date: 14:11 2018/10/23
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upt = (UsernamePasswordToken) authenticationToken;
        String userName = upt.getUsername();
        String password = String.valueOf(upt.getPassword());
        User user = userService.findUserByName(userName);
        if(user != null){
            return new SimpleAuthenticationInfo(userName,password,getName());
        }

        return null;
    }
}
