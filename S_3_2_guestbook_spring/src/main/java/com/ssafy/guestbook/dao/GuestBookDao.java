package com.ssafy.guestbook.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.guestbook.dto.GuestBookDto;

public interface GuestBookDao {

    public List<GuestBookDto> listArticle() throws SQLException;
    public GuestBookDto getArticle(int articleno) throws SQLException;
    public int writeArticle(GuestBookDto guestBookDto) throws SQLException;
    public int updateArticle(GuestBookDto guestBookDto) throws SQLException;
    public int deleteArticle(int articleno) throws SQLException;
    
}
