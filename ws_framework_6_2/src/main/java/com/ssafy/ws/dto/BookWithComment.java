package com.ssafy.ws.dto;

public class BookWithComment {
    private String isbn;
    private String title;
    private String author;
    private int price;
    private String content;
    private int rating;
    private String comment;

    // 기본 생성자
    public BookWithComment() {
    }

    // 생성자
    public BookWithComment(String isbn, String title, String author, int price, String content, int rating, String comment) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.content = content;
        this.rating = rating;
        this.comment = comment;
    }

    // Getter / Setter
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
