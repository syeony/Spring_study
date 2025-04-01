package com.ssafy.ws.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Book {
	private String isbn;
    private String title;
    private String author;
    private int price;
    private String content;
    private List<Comment> list;
    private String img;
    
    @JsonIgnore
    private Double avg_rating;
    
	public Double getavg_rating() {
		return avg_rating;
	}
	public void setavg_rating(Double avg_rating) {
		this.avg_rating = avg_rating;
	}
	public List<Comment> getList() {
		return list;
	}
	public void setList(List<Comment> list) {
		this.list = list;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
    
    
}
