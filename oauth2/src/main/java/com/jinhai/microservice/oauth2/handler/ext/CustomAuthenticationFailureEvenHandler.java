package com.jinhai.microservice.oauth2.handler.ext;
import com.jinhai.microservice.oauth2.handler.AbstractAuthenticationFailureEvenHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @Auther: maojian
 * @Date: 2019/3/5 15:37
 * @Description:
 */
@Component
@Slf4j
public class CustomAuthenticationFailureEvenHandler extends AbstractAuthenticationFailureEvenHandler {
    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent event) {
        super.onApplicationEvent(event);
    }

    /**
     * 处理登录失败方法
     * <p>
     *
     * @param authenticationException 登录的authentication 对象
     * @param authentication          登录的authenticationException 对象
     */
    @Override
    public void handle(AuthenticationException authenticationException, Authentication authentication) {
        log.info("用户：{} 登录失败，异常：{}", authentication.getPrincipal(), authenticationException.getLocalizedMessage());
    }
}
