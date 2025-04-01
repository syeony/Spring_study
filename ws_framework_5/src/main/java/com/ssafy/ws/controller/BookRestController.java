package com.ssafy.ws.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.BookWithComment;
import com.ssafy.ws.model.service.BookService;

@RequestMapping("/bookapi")
@CrossOrigin("*")
@RestController
public class BookRestController {

	private static final Logger log = LoggerFactory.getLogger(BookRestController.class);
    
    @Autowired
    private BookService service;
    
    @GetMapping("/book")
    public List<Book> listArticle() throws Exception{
    	return service.listArticle();
    }
    
    @GetMapping("/book/{isbn}")
    public Book getArticle(@PathVariable String isbn) throws Exception{
    	Book dto=service.getArticle(isbn);
    	return dto;
    }
    
//    @PostMapping("/book")
//    public int writeArticle(@RequestBody Book Book) throws Exception{
//    	return service.writeArticle(Book);
//    }
    
    @PostMapping("/book")
    public ResponseEntity<?> writeArticle(@RequestBody Book Book) throws Exception{
    	int result=service.writeArticle(Book);
    	if(result>0) {
    		return new ResponseEntity<>(result, HttpStatus.CREATED); //201
    	}else {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    }
    
    @PutMapping("/book")
    public int updateArticle(@RequestBody Book Book) throws Exception{
    	int result=service.updateArticle(Book);
    	return result;
    }
    
    @DeleteMapping("/book/{isbn}")
    public int deleteArticle(@PathVariable String isbn) throws Exception{
    	int result=service.deleteArticle(isbn);
    	return result;
    }
    
    @GetMapping("/getMaxAverageRatingByAuthor")
    public List<Book> getMaxAverageRatingByAuthor(String author) throws Exception{
    	return service.getMaxAverageRatingByAuthor(author);
    }
    
    @GetMapping("/getTop5")
    public List<BookWithComment> getTop5() throws Exception{
    	return service.getTop5();
    }
}
