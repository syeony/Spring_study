package com.ssafy.guestbook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.guestbook.dto.GuestBookDto;
import com.ssafy.guestbook.dto.MemberDto;

@Mapper
public interface GuestBookDao {

	public List<GuestBookDto> listArticle();
	public GuestBookDto getArticle(int articleno);
	public int writeArticle(GuestBookDto dto);
	public int updateArticle(GuestBookDto dto);
	public int deleteArticle(int articleno);
    
}
