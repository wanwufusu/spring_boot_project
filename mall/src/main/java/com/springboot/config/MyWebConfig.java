package com.springboot.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.Filter;
import javax.validation.Validation;
import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/22
 * @since 1.0.0
 */
@Configuration
public class MyWebConfig extends WebMvcConfigurationSupport {

/*    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new CorsFilter());
        ArrayList<String> url = new ArrayList<>();
        url.add("/*");
        filterFilterRegistrationBean.setUrlPatterns(url);
        return filterFilterRegistrationBean;
    }*/


    /**
     * 文件上传注册
     * @return
     */
    @Bean("multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(4194304);
        return commonsMultipartResolver;
    }
}
