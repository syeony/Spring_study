package com.ssafy.rest.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.rest.dto.GuestBookDto;

@Mapper
public interface GuestBookDao {

	public List<GuestBookDto> listArticle();
	public GuestBookDto getArticle(int articleno);
	public int writeArticle(GuestBookDto dto);
	public int updateArticle(GuestBookDto dto);
	public int deleteArticle(int articleno);
    
}
