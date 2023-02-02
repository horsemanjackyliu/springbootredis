package com.sap.springbootshiro5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springbootshiro5Application {
	private static final Logger log = LoggerFactory.getLogger(Springbootshiro5Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Springbootshiro5Application.class, args);
		log.info("Springboot server has been started successfully");
	}

}
