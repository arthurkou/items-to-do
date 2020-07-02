package com.goJavaFullStack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GoJavaFullStackApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoJavaFullStackApplication.class, args);
	}

}
