package com.springboot.pizzaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@ComponentScan(basePackages={"com.springboot.pizzaria.controller"})	//QualifiedName para identificar a pasta do controller
@SpringBootApplication
@Configuration
public class Application extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);	
	}
	
	@Bean	
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;		
	}	
}
