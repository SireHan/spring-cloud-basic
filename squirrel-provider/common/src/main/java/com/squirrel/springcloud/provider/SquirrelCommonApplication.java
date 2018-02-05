package com.squirrel.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:domain.properties")
public class SquirrelCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquirrelCommonApplication.class, args);
	}
}
