package com.ssafy.guestbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.ssafy.rest.dao")
public class GuestbookLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestbookLoginApplication.class, args);
	}

}
