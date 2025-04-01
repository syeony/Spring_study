package com.ssafy.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mybatis.dto.GuestBookDto;
import com.ssafy.mybatis.dto.MemberDto;

@Mapper
public interface GuestBookMapper {
	//단건조회. DTO에 단건조회의 interface랑 동일하다. 
	public GuestBookDto selectGuestBook(int articleno);
	
	//단건 입력.
	public int writeGuestBook(GuestBookDto dto);
	
	//어떤 사람이 쓴 글 전체 조회. 
	public List<GuestBookDto> selectByUser(String userid);
	
	public MemberDto selectUser(String id);
	
}
