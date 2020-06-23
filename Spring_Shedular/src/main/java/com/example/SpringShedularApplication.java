package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringShedularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringShedularApplication.class, args);
	}

}
