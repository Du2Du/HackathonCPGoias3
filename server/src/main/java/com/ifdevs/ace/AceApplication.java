package com.ifdevs.ace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class AceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AceApplication.class, args);
	}

}
