package com.ssafy.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.dto.MemberDto;
import com.ssafy.rest.service.UserService;

@RequestMapping("/admin")
@CrossOrigin("*")
@RestController
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    
    @Autowired
    private UserService service;
    
    //위처럼 해도되고 아래처럼 해도되고 
    
//    public AdminController(UserService service) {
//    	this.service = service;
//    }
    
//    @GetMapping("/user") // /admin/user
//    public List<MemberDto> userList(){
//    	return service.userList();                                                            
//    }
    
    @GetMapping("/user") // /admin/user
    public ResponseEntity<?> userList(){ //? extends Object
    	List<MemberDto> list=service.userList();
    	
    	if(list!=null && list.isEmpty()) {
//    		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);       //200   정상
    		return ResponseEntity.ok().body(list);
    	}else {
//    		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);       //204 값이없어
    		return ResponseEntity.noContent().build(); //204
    	}
    	                                                  
    }

    @GetMapping("/user/{id}") // /admin/user/ssafy
    public MemberDto userInfo(@PathVariable String id) {
    	MemberDto dto = service.userInfo(id);
    	return dto; // dto -> json으로 출력. 왜냐? RestController로  선언되어있기 때문에! 
    }
    
    @PostMapping("/user")
    public MemberDto registerUser(@RequestBody MemberDto dto) {
    	service.registerUser(dto);
    	return dto;
    }
    
    @PutMapping("/user/{id}")
    public MemberDto updateUser(@PathVariable String id, @RequestBody MemberDto memberDto) {
    	MemberDto dto=service.updateUser(memberDto);
    	return dto;
    }
    
    @DeleteMapping("/user/{id}")
    public int deleteUser(@PathVariable String id) {
    	return service.deleteUser(id);
    }


}
