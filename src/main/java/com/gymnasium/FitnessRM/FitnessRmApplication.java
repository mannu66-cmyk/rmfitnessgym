package com.gymnasium.FitnessRM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
public class FitnessRmApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessRmApplication.class, args);
	}

}
