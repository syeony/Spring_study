package com.ssafy.mybatis.service;

import java.util.List;

import com.ssafy.mybatis.dto.GuestBookDto;


public interface GuestBookService {
    
	public List<GuestBookDto> listArticle();
    public GuestBookDto getArticle(int articleno);
    public int writeArticle(GuestBookDto guestBookDto);
    public int updateArticle(GuestBookDto guestBookDto);
    public int deleteArticle(int articleno);

    
}
