package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.dto.Book;

public interface BookService {

	public List<Book> listArticle() throws Exception;
    public Book getArticle(String isbn) throws Exception;
    public int writeArticle(Book Book) throws Exception;
    public int updateArticle(Book Book) throws Exception;
    public int deleteArticle(String isbn) throws Exception;
    
}
