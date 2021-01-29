package com.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EntityScan({"com.commons.entity"})
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class TicketLogicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketLogicServiceApplication.class, args);
	}

}
