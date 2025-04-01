package com.ssafy.guestbook.service;

import java.util.List;
import java.util.Map;

import com.ssafy.guestbook.dto.MemberDto;

public interface UserService {

    public MemberDto login(String userid, String userpwd);
    
//    REST 
    public List<MemberDto> userList();
    public MemberDto userInfo(String userid);
    public MemberDto registerUser(MemberDto memberDto);
    public MemberDto updateUser(MemberDto memberDto);
    public int deleteUser(String userid);
}
