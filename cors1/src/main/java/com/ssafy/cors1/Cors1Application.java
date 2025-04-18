package com.ssafy.cors1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Cors1Application {
	
	
	private static final Logger log = LoggerFactory.getLogger(Cors1Application.class);
	
	@CrossOrigin(origins="http://localhost:18080")
	@GetMapping("/hello")
	public String hello() {
		log.info("호출됨");
		return "hello. 8080";
	}

	public static void main(String[] args) {
		SpringApplication.run(Cors1Application.class, args);
	}

}
