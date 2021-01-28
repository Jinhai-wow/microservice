package com.jinhai.microservice.eurekaclient;

import com.jinhai.microservice.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author Jinhai
 * @date 15:24 2020/10/23
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableCustomSwagger2
@EnableFeignClients
@EnableCircuitBreaker
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

}
