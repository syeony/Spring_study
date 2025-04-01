package com.ssafy.ws.model.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.dto.Book;

public interface BookRepo {
	public List<Book> listArticle() throws SQLException;
    public Book getArticle(String isbn) throws SQLException;
    public int writeArticle(Book Book) throws SQLException;
    public int updateArticle(Book Book) throws SQLException;
    public int deleteArticle(String isbn) throws SQLException;
}
