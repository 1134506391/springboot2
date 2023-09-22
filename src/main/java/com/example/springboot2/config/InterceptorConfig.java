package com.example.springboot2.config;

import com.example.springboot2.interceptor.LoginInterceptor;
import com.example.springboot2.interceptor.UserInfoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public UserInfoInterceptor userInfoInterceptor(){
        return new UserInfoInterceptor();
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }


    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginInterceptor())
                .excludePathPatterns("/**");
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login");//开放登录路径

    }
}
