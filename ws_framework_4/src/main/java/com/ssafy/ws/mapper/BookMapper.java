package com.ssafy.ws.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.Comment;

@Mapper
public interface BookMapper {
	
	public List<Book> listArticle();
    public Book getArticle(String isbn);
    public List<Comment> bookInfoWithComment(String isbn);
    public int writeArticle(Book Book);
    public int updateArticle(Book Book);
    public int deleteArticle(String isbn);

}
