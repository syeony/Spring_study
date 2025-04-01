package com.ssafy.springweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.springweb.controller.HomeController;

@Controller
@RequestMapping("/mvc")
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/hello")
	public String home(Model model) {
		log.debug("home");
		model.addAttribute("msg","안녕하세요 Spring MVC");
		
		return "home";
	}
	
	// ~~~/hello2?name=홍길동&age=20 
	@GetMapping("/hello4")
	public String home4(Model model, UserDto dto) {
		log.debug("test: {}, {}", dto.getName(), dto.getAge());
		model.addAttribute("msg","안녕하세요 Spring MVC");
		model.addAttribute("dto",dto);
		
		return "home4";
	}
	
	@PostMapping("/hello5")
	public String home5(Model model, UserDto dto) {
		log.debug("test: {}, {}", dto.getName(), dto.getAge());
		model.addAttribute("msg","안녕하세요 Spring MVC");
		model.addAttribute("dto",dto);
		
		return "home5";
	}
}
