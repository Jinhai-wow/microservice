package com.jinhai.microservice.oauth2.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;

/**
 *
 * @Author Jinhai
 * @Date 17:10 2020/10/29
 **/
//@JsonSerialize(using = BdcAuth2ExceptionSerializer.class)
public class MethodNotAllowedException extends AuthException {

    public MethodNotAllowedException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "method_not_allowed";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.METHOD_NOT_ALLOWED.value();
    }

}
