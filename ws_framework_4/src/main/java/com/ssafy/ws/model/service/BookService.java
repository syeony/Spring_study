package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.Comment;

public interface BookService {

	public List<Book> listArticle() throws Exception;
    public Book getArticle(String isbn) throws Exception;
    public List<Comment> bookInfoWithComment(String isbn) throws Exception;
    public int writeArticle(Book Book) throws Exception;
    public int updateArticle(Book Book) throws Exception;
    public int deleteArticle(String isbn) throws Exception;
}
