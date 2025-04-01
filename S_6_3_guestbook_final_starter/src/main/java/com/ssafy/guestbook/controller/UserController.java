package com.ssafy.guestbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.guestbook.dto.MemberDto;
import com.ssafy.guestbook.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

//로그인 아웃 관리 CONTROLLER
@Controller
public class UserController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;
    
    @PostMapping("/login")
    public String login(String userid, String userpwd, Model model, HttpServletResponse response) {
    	
    	logger.debug("userid:{}, userpwd:{}",userid,userpwd);
    	MemberDto dto = service.login(userid, userpwd);
    	if(dto != null) { //로그인 성공.->쿠키를 내려주기.
    		Cookie c = new Cookie("ssafy_id", dto.getUserid()); //한글이면 대응필요
    		c.setMaxAge(60*60*24*30); //초단위로 입력(30일) 0:삭제,-:browser닫으면 제거 
    		c.setPath("/"); //하위 모든 경로에 cookie를 포함.
    		
    		response.addCookie(c);
    		
    	}
    	return "redirect:/"; //redirect : browser가 /로 요청.
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
    	Cookie c= new Cookie("ssafy_id",null);
    	c.setPath("/");
    	c.setMaxAge(0); //0-->삭제 
    	
    	response.addCookie(c);
    	
    	return "redirect:/";
    }
}
