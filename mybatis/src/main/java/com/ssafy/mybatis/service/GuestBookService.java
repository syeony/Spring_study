package com.ssafy.mybatis.service;

import java.util.List;

import com.ssafy.mybatis.dto.GuestBookDto;
import com.ssafy.mybatis.dto.MemberDto;

public interface GuestBookService {
	public GuestBookDto selectGuestBook(int id);
	public int writeGuestBook(GuestBookDto dto);
	public List<GuestBookDto> selectByUser(String userid);
	public MemberDto selectUserGuestBook(String userid);
}
