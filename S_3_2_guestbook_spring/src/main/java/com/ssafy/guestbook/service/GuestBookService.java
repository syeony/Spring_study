package com.ssafy.guestbook.service;

import java.util.List;

import com.ssafy.guestbook.dto.GuestBookDto;

public interface GuestBookService {

    public List<GuestBookDto> listArticle() throws Exception;
    public GuestBookDto getArticle(int articleno) throws Exception;
    public int writeArticle(GuestBookDto guestBookDto) throws Exception;
    public int updateArticle(GuestBookDto guestBookDto) throws Exception;
    public int deleteArticle(int articleno) throws Exception;
    
}
