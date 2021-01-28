package com.jinhai.microservice.oauth2.handler;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @Auther: maojian
 * @Date: 2019/3/5 15:41
 * @Description: 认证失败事件处理器
 */
public abstract class AbstractAuthenticationFailureEvenHandler implements ApplicationListener<AbstractAuthenticationFailureEvent> {
    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent event) {
        AuthenticationException authenticationException = event.getException();
        Authentication authentication = (Authentication) event.getSource();

        handle(authenticationException, authentication);
    }

    /**
     * @Function 处理登录成功方法
     * @author   maojian
     * @Date     2019/3/5 15:44
     * @param authenticationException 登录的authentication 对象
     * @param authentication 登录的authenticationException 对象
     * @return   void
     */
    public abstract void handle(AuthenticationException authenticationException, Authentication authentication);
}
