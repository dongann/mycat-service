package com.mycat.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyCatApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyCatApplication.class, args);
	}
}
