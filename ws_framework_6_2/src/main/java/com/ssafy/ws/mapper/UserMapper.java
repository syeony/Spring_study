package com.ssafy.ws.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ws.dto.User;


@Mapper
public interface UserMapper {
	public User login(Map<String, String> map);

	//    REST
    public List<User> userList();
    public User userInfo(String id);
    public int registerUser(User user);
    public int updateUser(User user);
    public int deleteUser(String id);
}
