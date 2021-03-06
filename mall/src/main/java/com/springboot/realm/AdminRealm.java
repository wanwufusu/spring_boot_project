package com.springboot.realm;

import com.springboot.bean.admin.Admin;

import com.springboot.service.admin.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Admin的自定义Realm
 */
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    AdminService service;

    /**
     * 这是Realm的名称
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        super.setName("AdminRealm");
    }

    /**
     * ☢授权方法☣
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Admin admin = (Admin) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //这里需要获取role角色  admin需要role
        return info;
    }

    /**
     * 认证方法
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken uptoken = (UsernamePasswordToken) authenticationToken;
        String username = uptoken.getUsername();
        String password = new String(uptoken.getPassword());
        Admin user = service.findAdminByName(username).get(0);

        //password = new Md5Hash(password, user.getUsername(), 2).toString();

        if (user != null && user.getPassword().equals(password)) {
            return new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
            //返回user
        } else {
            return null;
            //当没查到时返回null，subject.login()外的try-catch会捕获这个异常
        }
    }
}
