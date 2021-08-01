package com.example.usermanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * User:DELL
 * Date:2021-07-29
 * Time:10:43
 */

@Configuration
public class AppConfig implements WebMvcConfigurer {

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截规则/权限
        registry.addInterceptor(new LoginInterceptor())
                //配置拦截路由
                .addPathPatterns("/**")
                .excludePathPatterns("/js/**.js")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/css/**.css")
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/user/login");

    }
}
