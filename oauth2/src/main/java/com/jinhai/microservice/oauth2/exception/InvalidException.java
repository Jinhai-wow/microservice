package com.jinhai.microservice.oauth2.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * @Author Jinhai
 * @Date 17:10 2020/10/29
 **/
//@JsonSerialize(using = BdcAuth2ExceptionSerializer.class)
public class InvalidException extends AuthException {

    public InvalidException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "invalid_exception";
    }

    @Override
    public int getHttpErrorCode() {
        return 426;
    }

}
