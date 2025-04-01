package com.ssafy.guestbook.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.guestbook.dao.UserDao;
import com.ssafy.guestbook.dto.MemberDto;

@Service
public class UserServiceImpl implements UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserDao dao;

    @Override
    public MemberDto login(String userid, String userpwd) {
    	Map<String, String> map = new HashMap<>();
    	map.put("userid", userid);
    	map.put("userpwd", userpwd);
    	
    	return dao.login(map);
    }
    
    @Override
    public List<MemberDto> userList() {
        return dao.userList();
    }

    @Override
    public MemberDto userInfo(String userid) {
        return dao.userInfo(userid);
    }

    @Override
    public MemberDto registerUser(MemberDto memberDto) {
    	int result = dao.registerUser(memberDto);
    	if(result == 1) {
    		return memberDto;
    	}else {
            return null;
    	}
    }

    @Override
    public MemberDto updateUser(MemberDto memberDto) {
    	int result =  dao.updateUser(memberDto);
    	if(result == 1) {
    		return memberDto;
    	}else {
            return null;
    	}
    }

    @Override
    public int deleteUser(String userid) {
        return dao.deleteUser(userid);
    }
}
