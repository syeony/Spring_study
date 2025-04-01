package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.BookWithComment;
import com.ssafy.ws.dto.Comment;
import com.ssafy.ws.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
    private BookMapper guestBookDao;

    @Override
    public List<Book> listArticle() throws Exception {
        return guestBookDao.listArticle();
    }

    @Override
    public Book getArticle(String isbn) throws Exception {
        return guestBookDao.getArticle(isbn);
    }
    
    @Override
    public List<Comment> bookInfoWithComment(String isbn) throws Exception{
    	return guestBookDao.bookInfoWithComment(isbn);
    }

    @Override
    public int writeArticle(Book Book) throws Exception {
        if(Book.getTitle() == null || Book.getContent() == null|| Book.getAuthor() == null) {
            throw new Exception();
        }

        return guestBookDao.writeArticle(Book);
    }

    @Override
    public int updateArticle(Book Book) throws Exception {
        return guestBookDao.updateArticle(Book);
    }

    @Override
    public int deleteArticle(String isbn) throws Exception {
        return guestBookDao.deleteArticle(isbn);
    }
    
    @Override
    public List<Book> getMaxAverageRatingByAuthor(String author) throws Exception{
    	return guestBookDao.getMaxAverageRatingByAuthor(author);
    }

    @Override
    public List<BookWithComment> getTop5() throws Exception{
    	return guestBookDao.getTop5();
    }
}
