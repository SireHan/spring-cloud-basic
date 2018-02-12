package com.squirrel.license.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:common.properties")
public class SquirrelLicenseCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquirrelLicenseCommonApplication.class, args);
	}
}
