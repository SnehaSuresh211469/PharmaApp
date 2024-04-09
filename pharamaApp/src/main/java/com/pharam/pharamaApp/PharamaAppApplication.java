package com.pharam.pharamaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.pharam.pharamaApp")
@SpringBootApplication
public class PharamaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharamaAppApplication.class, args);
	}

}
