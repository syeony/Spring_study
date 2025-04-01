package com.ssafy.mybatis.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.mybatis.dto.UserDto;

@Controller
@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	
	private static final Logger log = LoggerFactory.getLogger(RestController.class);
	
	@GetMapping("/user")
	public UserDto user() {
		UserDto dto=new UserDto();
		dto.setName("홍길동");
		dto.setAge(20);
		return dto;
	}
	
	@GetMapping("/user2")
	public Map<String,String> use2r() {
		Map<String,String> map=new HashMap<>();
		map.put("test","hello");
		map.put("test1","hello2");
		return map;
	}
	
	// ?name=홍길동&age=20...이 아니라 jsontype
	@PostMapping("/user")
	public @ResponseBody UserDto user3(@RequestBody UserDto dto) {
		log.info("userDto: {}",dto.getName());
		log.info("userDto: {}",dto.getAge());

		return dto;
	}
	
	//url이 /user/1 --> 1이 path variable
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable String id) {
		log.info("id: {}", id);
		return "delete...";
	}
}
