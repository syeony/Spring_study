package com.ssafy.rest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.rest.dao.UserDao;
import com.ssafy.rest.dto.MemberDto;

@Service
public class UserServiceImpl implements UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserDao dao;

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
