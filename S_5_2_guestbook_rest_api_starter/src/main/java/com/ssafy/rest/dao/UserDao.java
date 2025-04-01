package com.ssafy.rest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.rest.dto.MemberDto;

@Mapper
public interface UserDao {

//    REST
    public List<MemberDto> userList();
    public MemberDto userInfo(String userid);
    public int registerUser(MemberDto memberDto);
    public int updateUser(MemberDto memberDto);
    public int deleteUser(String userid);
}
