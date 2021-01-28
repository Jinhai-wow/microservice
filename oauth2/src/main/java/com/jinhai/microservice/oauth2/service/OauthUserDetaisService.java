package com.jinhai.microservice.oauth2.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 自定义id验证ID登录
 * @author Jinhai
 * @version 1.0
 * @className OauthUserDetaisService
 * @date 2020/10/29 16:57
 */
public interface OauthUserDetaisService extends UserDetailsService{
    UserDetails loadUserById(String id) throws UsernameNotFoundException;
}
