package com.ssafy.guestbook.service;

import java.util.List;

import com.ssafy.guestbook.dto.GuestBookDto;

public interface GuestBookService {
    
	public List<GuestBookDto> listArticle();
	public GuestBookDto getArticle(int articleno);
	public int writeArticle(GuestBookDto dto);
	public int updateArticle(GuestBookDto dto);
	public int deleteArticle(int articleno);
    
}
