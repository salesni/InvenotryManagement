package com.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.commons.entity"})
public class InventarioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioServiceApplication.class, args);
	}

}
