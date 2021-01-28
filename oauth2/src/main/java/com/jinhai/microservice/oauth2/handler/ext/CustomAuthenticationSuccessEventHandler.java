package com.jinhai.microservice.oauth2.handler.ext;

import com.jinhai.microservice.oauth2.handler.AbstractAuthenticationSuccessEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @Auther: maojian
 * @Date: 2019/3/5 16:44
 * @Description:
 */
@Slf4j
@Component
public class CustomAuthenticationSuccessEventHandler extends AbstractAuthenticationSuccessEventHandler {
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        super.onApplicationEvent(event);
    }

    /**
     * @Function 处理登录成功方法 获取到登录的authentication 对象
     * @author   maojian
     * @Date     2019/3/5 17:00
     * @param authentication 登录对象
     * @return   void
     */
    @Override
    public void handle(Authentication authentication) {
        log.info("用户：{} 登录成功", authentication.getPrincipal());
    }
}
