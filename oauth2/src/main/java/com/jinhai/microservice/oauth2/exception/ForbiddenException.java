package com.jinhai.microservice.oauth2.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;

/**
 *
 * @Author Jinhai
 * @Date 17:10 2020/10/29
 **/
//@JsonSerialize(using = BdcAuth2ExceptionSerializer.class)
public class ForbiddenException extends AuthException {
    public ForbiddenException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "access_denied";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.FORBIDDEN.value();
    }
}
