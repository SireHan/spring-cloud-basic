package com.squirrel.springcloud.squirrel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:service.properties")
public class SquirrelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquirrelServiceApplication.class, args);
	}
}
