package com.example.usuario;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.usuario"})
public class ApiRestUsuarioApplication extends SpringBootServletInitializer implements CommandLineRunner {

	 @PostConstruct
     void started() {
       TimeZone.setDefault(TimeZone.getTimeZone("GMT-5"));
	 }
	 
	public static void main(String[] args) {
		SpringApplication.run(ApiRestUsuarioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
