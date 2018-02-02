package com.squirrel.springcloud.squirrel.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySource("classpath:gen.properties")
public class SquirrelGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquirrelGenApplication.class, args);
	}
}
