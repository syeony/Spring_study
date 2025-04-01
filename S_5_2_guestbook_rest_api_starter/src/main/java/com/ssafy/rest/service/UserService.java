package com.ssafy.rest.service;

import java.util.List;
import java.util.Map;

import com.ssafy.rest.dto.MemberDto;

public interface UserService {

//    REST 
    public List<MemberDto> userList();
    public MemberDto userInfo(String userid);
    public MemberDto registerUser(MemberDto memberDto);
    public MemberDto updateUser(MemberDto memberDto);
    public int deleteUser(String userid);
}
