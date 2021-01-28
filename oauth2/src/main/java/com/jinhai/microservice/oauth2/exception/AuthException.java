package com.jinhai.microservice.oauth2.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 *
 * @Author Jinhai
 * @Date 17:08 2020/10/29
 **/
//@JsonSerialize(using = BdcAuth2ExceptionSerializer.class)
public class AuthException extends OAuth2Exception {
    @Getter
    private String errorCode;

    public AuthException(String msg) {
        super(msg);
    }

    public AuthException(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }
}
