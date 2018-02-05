package com.squirrel.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:dao.properties")
public class SquirrelDaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquirrelDaoApplication.class, args);
	}
}
