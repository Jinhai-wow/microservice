package com.jinhai.microservice.eurekaclient2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @author Jinhai
 * @Date 15:19 2020/10/23
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.jinhai.microservice.eurekaclient2.mapper")
public class EurekaClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient2Application.class, args);
	}

}
