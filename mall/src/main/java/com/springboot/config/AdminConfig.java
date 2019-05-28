package com.springboot.config;


import com.springboot.realm.AdminRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class AdminConfig {

    /**
     * 注册realm到容器
     *
     * @return
     */
    @Bean
    public AdminRealm getRealm() {
        return new AdminRealm();
    }

    /**
     * 用DefaultWebSecurityManager 配置SecurityManager
     *
     * @param realm
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(AdminRealm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(realm);
        securityManager.setRealm(realm);
        return securityManager;
    }

    /**
     * ❤Filter工厂❤
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactory = new ShiroFilterFactoryBean();
        filterFactory.setSecurityManager(securityManager);
        filterFactory.setLoginUrl("/admin/dashboard");
        filterFactory.setUnauthorizedUrl("/admin/login");
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/admin/login", "anon");
        filterMap.put("/admin/**", "authc");
        filterFactory.setFilterChainDefinitionMap(filterMap);
        return filterFactory;
    }

    /**
     * 开启对shior的支持
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
