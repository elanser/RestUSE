package com.example.RestUSE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SpringBootApplication
public class RestUseApplication {
	public static ApplicationContext context;
	public static SessionFactory sessionFactory;
	public static void main(String[] args) {
		context = SpringApplication.run(RestUseApplication.class, args);
		sessionFactory = new Configuration().configure()
				.buildSessionFactory();

	}

}
