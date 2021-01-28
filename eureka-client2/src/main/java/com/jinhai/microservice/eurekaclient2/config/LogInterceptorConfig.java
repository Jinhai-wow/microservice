package com.jinhai.microservice.eurekaclient2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jinhai
 * @version 1.0
 * @className LogInterceptorConfig
 * @date 2020/12/18 15:36
 */
@Configuration
public class LogInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        registry.addInterceptor(new LogInterceptor());
//        registration.addPathPatterns("/**");//所有路径都被拦截
//        registration.excludePathPatterns(
//                "/pages/login.html",        // 登录页不拦截
//                "/user/**"                  // 登录相关接口不拦截
//        );
//        registration.excludePathPatterns("" +
//                        "/assets/**",             // assets文件夹里文件不拦截
//                "/**/*.js",              //js静态资源不拦截
//                "/**/*.css"             //css静态资源不拦截
//        );
    }
}
