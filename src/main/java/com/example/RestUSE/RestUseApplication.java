package com.example.RestUSE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestUseApplication {
	public static ApplicationContext context;
	public static void main(String[] args) {
		context = SpringApplication.run(RestUseApplication.class, args);
	}

}
