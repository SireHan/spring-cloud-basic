package com.squirrel.springcloud.squirrel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:domain.properties")
public class SquirrelDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquirrelDomainApplication.class, args);
	}
}
