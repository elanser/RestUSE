package com.example.RestUSE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaRepositories
@EntityScan("com.example.RestUSE.Entity")
@SpringBootApplication
public class RestUseApplication {
	public static ApplicationContext context;
	public static SessionFactory sessionFactory;
	public static void main(String[] args) {
		context = SpringApplication.run(RestUseApplication.class, args);
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	// CORS!!!!!
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//registry.addMapping("/**").allowedOrigins("http://localhost:8080");
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
}
