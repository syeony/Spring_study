package com.ssafy.guestbook.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.guestbook.dto.MemberDto;

@Mapper
public interface UserDao {

    public MemberDto login(Map<String, String> map);

	//    REST
    public List<MemberDto> userList();
    public MemberDto userInfo(String userid);
    public int registerUser(MemberDto memberDto);
    public int updateUser(MemberDto memberDto);
    public int deleteUser(String userid);
}
