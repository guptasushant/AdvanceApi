package com.advance.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AdvanceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceApiApplication.class, args);
	}

}
