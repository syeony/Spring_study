package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.repo.BookRepo;
import com.ssafy.ws.dto.Book;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
    private BookRepo guestBookDao;

    @Override
    public List<Book> listArticle() throws Exception {
        return guestBookDao.listArticle();
    }

    @Override
    public Book getArticle(String isbn) throws Exception {
        return guestBookDao.getArticle(isbn);
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

}
