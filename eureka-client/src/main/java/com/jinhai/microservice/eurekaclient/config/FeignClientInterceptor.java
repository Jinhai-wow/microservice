package com.jinhai.microservice.eurekaclient.config;

import com.jinhai.microservice.commoncore.utils.TraceIdUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * feign拦截器，对请求添加链路id
 * @author Jinhai
 * @version 1.0
 * @className FeignClientInterceptor
 * @date 2020/12/18 14:59
 */
@Component
public class FeignClientInterceptor implements RequestInterceptor{
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String traceId = TraceIdUtil.getTraceId();
        if(!traceId.isEmpty()){
            requestTemplate.header("traceId",traceId);
        }
    }
}
