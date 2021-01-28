package com.jinhai.microservice.oauth2.service.impl;

import com.jinhai.microservice.oauth2.service.OauthUserDetaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Jinhai
 * @version 1.0
 * @className CustomUserDetailsServiceImpl
 * @date 2020/11/12 15:13
 */
public class CustomUserDetailsServiceImpl implements OauthUserDetaisService{

    @Autowired
    private CacheManager cacheManager;

    @Override
    public UserDetails loadUserById(String id) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //用户信息验证处理
        return null;
    }
}
