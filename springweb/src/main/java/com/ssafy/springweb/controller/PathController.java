package com.ssafy.springweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PathController {
	
	private static final Logger log = LoggerFactory.getLogger(PathController.class);
	
	// /user/1, user/2, user/3, user/4, .... path variable
	@GetMapping("/user/{id}")
	public String path(Model model, @PathVariable String id) {
		log.debug("id: {}",id);
		model.addAttribute("id",id);
		return "user"; //WEB-INF/views/user.jsp
	}
	
//	@GetMapping("/hello")
//	public String hello() {
//		return "hello"; //hello.jsp
//	}
	
	@GetMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mnv=new ModelAndView("hello");
//		mnv.setViewName("hello");
		
		return mnv; //hello.jsp
	}
	
}
