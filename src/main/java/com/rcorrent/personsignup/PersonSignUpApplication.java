package com.rcorrent.personsignup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.rcorrent.personsignup"})
public class PersonSignUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonSignUpApplication.class, args);
	}

}
