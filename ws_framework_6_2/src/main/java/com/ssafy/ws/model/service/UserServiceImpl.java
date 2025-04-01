package com.ssafy.ws.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.dto.User;
import com.ssafy.ws.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserMapper dao;

    @Override
    public User login(String id, String pass) {
    	Map<String, String> map = new HashMap<>();
    	map.put("id", id);
    	map.put("pass", pass);
    	
    	return dao.login(map);
    }
    
    @Override
    public List<User> userList() {
        return dao.userList();
    }

    @Override
    public User userInfo(String id) {
        return dao.userInfo(id);
    }

    @Override
    public User registerUser(User user) {
    	int result = dao.registerUser(user);
    	if(result == 1) {
    		return user;
    	}else {
            return null;
    	}
    }

    @Override
    public User updateUser(User user) {
    	int result =  dao.updateUser(user);
    	if(result == 1) {
    		return user;
    	}else {
            return null;
    	}
    }

    @Override
    public int deleteUser(String id) {
        return dao.deleteUser(id);
    }
}
