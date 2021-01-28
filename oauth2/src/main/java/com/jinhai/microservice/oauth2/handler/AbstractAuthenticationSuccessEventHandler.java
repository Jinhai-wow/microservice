package com.jinhai.microservice.oauth2.handler;

import cn.hutool.core.collection.CollUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;

/**
 * @Auther: maojian
 * @Date: 2019/3/5 16:50
 * @Description: 认证成功处理事件
 */
public abstract class AbstractAuthenticationSuccessEventHandler implements ApplicationListener<AuthenticationSuccessEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        Authentication authentication = (Authentication) event.getSource();
        if (CollUtil.isNotEmpty(authentication.getAuthorities())) {
            handle(authentication);
        }
    }

    /**
     * @Function 处理登录成功方法 获取到登录的authentication 对象
     * @author   maojian
     * @Date     2019/3/5 16:58
     * @param authentication 登录对象
     * @return   void
     */
    public abstract void handle(Authentication authentication);
}
