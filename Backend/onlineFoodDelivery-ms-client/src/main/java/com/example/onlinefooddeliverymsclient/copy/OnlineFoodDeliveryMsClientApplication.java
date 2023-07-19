package com.example.onlinefooddeliverymsclient.copy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
@EnableHystrix
@EnableEurekaClient
public class OnlineFoodDeliveryMsClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodDeliveryMsClientApplication.class, args);
	}

}
