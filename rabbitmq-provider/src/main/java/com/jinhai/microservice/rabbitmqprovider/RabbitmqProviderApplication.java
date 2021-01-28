package com.jinhai.microservice.rabbitmqprovider;

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
public class RabbitmqProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProviderApplication.class, args);
	}

}
