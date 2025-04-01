package com.ssafy.mybatis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ssafy.mybatis.dto.GuestBookDto;
import com.ssafy.mybatis.dto.MemberDto;
import com.ssafy.mybatis.mapper.GuestBookMapper;
import com.ssafy.mybatis.service.GuestBookService;

@Controller
public class GuestBookController {
	
	
	private static final Logger log = LoggerFactory.getLogger(GuestBookController.class);
	
	@Autowired
	private GuestBookService service;
	
	@GetMapping("/")
	public String home(Model model) {
		log.info("호출되었습니다.");
		
		//mapper를 호출하고 싶다.
		GuestBookDto dto=service.selectGuestBook(1);
		log.debug("dto조회: {}",dto);
		model.addAttribute("dto",dto);
		return "hello";
	}
	
	@GetMapping("/insert")
	public String insert(Model model) {
		GuestBookDto dto=new GuestBookDto();
		dto.setUserid("ssafy");
		dto.setSubject("이건제목");
		dto.setContent("내용");
		
		service.writeGuestBook(dto);
		model.addAttribute("dto",dto);
		return "hello";
	}
	
	// 한 사람이 쓴 전체글 조회. --> /select/ssafy
	@GetMapping("/select/{id}")
	public String list(Model model, @PathVariable String id) {
		log.debug("입력받은 id:{}", id);
		List<GuestBookDto> list =service.selectByUser(id);
		model.addAttribute("list",list);
		return "list";
		
	}
	
	@GetMapping("/selectUserGuestbook/{id}")
	public String getAll(Model model, @PathVariable String id) {
		MemberDto member = service.selectUserGuestBook(id);
		model.addAttribute("member",member);
		
		
		return "listall";
	}
	

}
