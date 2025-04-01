package com.ssafy.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//앞단에서 사용자 요청을 받는다. 
//lifecycle은 spring이 관리하도록 @Controller를 사용. 
@Controller
public class HelloController {
	
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/") //annotation으로 만들어져있음 post, get, put, ...
	public String hello(Model model) {
		String test="test";
		
		log.debug("debug: "+test);
		log.debug("debug: {}"+test);
		
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		System.out.println("/a로 Hello 호출 됨. !!!!!!!!!");
		model.addAttribute("message","안녕하세요. 담긴 메시지 입니다.");
		return "test";
	}
	
	@GetMapping("/next")
	public String hello2() {
		System.out.println("/b로 Hello 호출 됨. !!!!!!!!!");
		return "next";
	}
	
	@GetMapping("/home")
	public String home() {
		
		return "redirect:/"; //뒤로가기 
	}
	
}
