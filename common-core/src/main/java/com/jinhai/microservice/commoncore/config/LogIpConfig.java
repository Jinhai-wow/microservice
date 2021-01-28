package com.jinhai.microservice.commoncore.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 日志打印ip
 * @ClassName LogIpConfig
 * @Author Jinhai
 * @Date 2020/10/21 16:45
 * @Version 1.0
 */
public class LogIpConfig extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
        }
        return null;
    }
}
