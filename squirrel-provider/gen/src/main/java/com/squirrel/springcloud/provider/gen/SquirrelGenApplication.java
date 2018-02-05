package com.squirrel.springcloud.provider.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:gen.properties")
public class SquirrelGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquirrelGenApplication.class, args);
	}
}
