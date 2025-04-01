package com.ssafy.guestbook.controller;

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

import com.ssafy.guestbook.dto.MemberDto;
import com.ssafy.guestbook.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    
    @Autowired
    private UserService userService;
    
//    @GetMapping("/user")
//    public List<MemberDto> userList() {
//        List<MemberDto>  dto = userService.userList();
//        return dto;
//    }
//    
//    @GetMapping("/user/{userid}")
//    public MemberDto userInfo(@PathVariable String userid) {
//        return userService.userInfo(userid);
//    }
//    
//    @PostMapping("/user")
//    public MemberDto registerUser(@RequestBody MemberDto memberDto) {
//        logger.debug("userRegisger", memberDto);
//        MemberDto dto = userService.registerUser(memberDto);
//        return dto;
//    }
//
//
//    @PutMapping("/user/{userid}")
//    public MemberDto updateUser(@PathVariable String userid, @RequestBody MemberDto dto) {
//        logger.debug("updateUser:userid : {}, dto : {}, ", userid, dto);
//        if(userid.equals(dto.getUserid()) == false) {
//        	return null;
//        }
//        MemberDto resultDto = userService.updateUser(dto);
//    	return resultDto;
//    }
//    
//    
//    @DeleteMapping("/user/{userid}")
//    public void deleteUser(@PathVariable("userid")String userid) {
//        userService.deleteUser(userid);
//    }
    
    ///////////////////////////////////////////////////////////
    
    @Operation(summary="회원목록",description = "회원의 전체 목록을 반환합니다.")
	@GetMapping(value = "/user")
	public ResponseEntity<?> userList() {
	    List<MemberDto> list = userService.userList();
	    if(list != null && !list.isEmpty()) {
	         return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
	    } else {
	         return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }
	}
    
    @GetMapping(value = "/user/{userid}")
    public ResponseEntity<?> userInfo(@PathVariable("userid") String userid) {
        logger.debug("파라미터 : {}", userid);
        MemberDto memberDto = userService.userInfo(userid);
        if(memberDto != null) {
            return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }
    
    @PostMapping(value = "/user")
    public ResponseEntity<?> registerUser(@RequestBody MemberDto memberDto) {
    	MemberDto dto = userService.registerUser(memberDto);
        if(dto != null) {
            return new ResponseEntity<MemberDto>(dto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }
    
    @PutMapping(value = "/user/{userid}")
    public ResponseEntity<?> updateUser(@PathVariable String userid, @RequestBody MemberDto memberDto) {
    	MemberDto dto = userService.updateUser(memberDto);
        if( dto != null ){
            return new ResponseEntity<MemberDto>(dto, HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }
    
    @DeleteMapping(value = "/user/{userid}")
    public ResponseEntity<?> deleteUser(@PathVariable("userid") String userid) {
        int result = userService.deleteUser(userid);
        if( result == 1 ){
            return new ResponseEntity<Integer>(result, HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }
    
}
