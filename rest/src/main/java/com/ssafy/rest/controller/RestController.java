package com.ssafy.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {
	
	@GetMapping("/")
	@ResponseBody
	public String home(Model model) {
		
		return "home";
	}
}
