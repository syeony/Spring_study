package com.ssafy.ws.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.ws.dto.User;

public interface UserService {
	public User login(String id, String pass);

	//    REST
    public List<User> userList();
    public User userInfo(String id);
    public User registerUser(User user);
    public User updateUser(User user);
    public int deleteUser(String id);
}
