package com.jinhai.microservice.common.swagger.annotation;

import com.jinhai.microservice.common.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 *  是否开启swagger
 * @Author Jinhai
 * @Date 10:50 2020/9/14
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({com.jinhai.microservice.common.swagger.config.SwaggerAutoConfiguration.class})
public @interface EnableCustomSwagger2 {
}
