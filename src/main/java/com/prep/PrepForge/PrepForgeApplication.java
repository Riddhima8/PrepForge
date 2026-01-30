package com.prep.PrepForge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PrepForgeApplication {

	public static void main(String[] args) {

		SpringApplication.run(PrepForgeApplication.class, args);
	}
}
