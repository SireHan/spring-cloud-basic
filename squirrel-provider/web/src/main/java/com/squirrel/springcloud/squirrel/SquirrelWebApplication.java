package com.squirrel.springcloud.squirrel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SquirrelWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquirrelWebApplication.class, args);
	}
}
