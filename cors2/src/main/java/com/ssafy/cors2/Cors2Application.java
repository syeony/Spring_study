package com.ssafy.cors2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Cors2Application {

	@GetMapping("/hello")
	public String hello() {
		return "18080";
	}
	public static void main(String[] args) {
		SpringApplication.run(Cors2Application.class, args);
	}

}
