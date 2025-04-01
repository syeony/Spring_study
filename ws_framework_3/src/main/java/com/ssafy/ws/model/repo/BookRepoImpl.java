package com.ssafy.ws.model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.ws.dto.Book;

@Repository
public class BookRepoImpl implements BookRepo{
	@Autowired
    private DataSource dataSource;
    
    @Override
    public List<Book> listArticle() throws SQLException {
        List<Book> list = new ArrayList<Book>();

        StringBuilder sql = new StringBuilder();
        sql.append("select isbn, title, author, price, content \n");
        sql.append("from book \n");
        sql.append("order by isbn desc");
        
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql.toString());){

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Book guestBookDto = new Book();
                guestBookDto.setIsbn(rs.getString("isbn"));
                guestBookDto.setTitle(rs.getString("title"));
                guestBookDto.setAuthor(rs.getString("author"));
                guestBookDto.setPrice(rs.getInt("price"));
                guestBookDto.setContent(rs.getString("content"));
                
                list.add(guestBookDto);
            }
        }
        
        return list;
    }

    
    @Override
    public Book getArticle(String isbn) throws SQLException {
        Book guestBookDto = null;
        
        StringBuilder sql = new StringBuilder();
        sql.append("select isbn, title, author, price, content \n");
        sql.append("from book \n");
        sql.append("where isbn = ?");
        
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
        	
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                guestBookDto = new Book();
                guestBookDto.setIsbn(rs.getString("isbn"));
                guestBookDto.setTitle(rs.getString("title"));
                guestBookDto.setAuthor(rs.getString("author"));
                guestBookDto.setPrice(rs.getInt("price"));
                guestBookDto.setContent(rs.getString("content"));
            }
        }

        return guestBookDto;
    }

    
    @Override
    public int writeArticle(Book Book) throws SQLException {
        StringBuilder insertMember = new StringBuilder();
        insertMember.append("insert into book (isbn, title, author, price, content) \n");
        insertMember.append("values (?, ?, ?, ?, ?)");

        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(insertMember.toString());){
        	
        	pstmt.setString(1, Book.getIsbn());
            pstmt.setString(2, Book.getTitle());
            pstmt.setString(3, Book.getAuthor());
            pstmt.setInt(4, Book.getPrice());
            pstmt.setString(5, Book.getContent());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int updateArticle(Book Book) throws SQLException {
        StringBuilder insertMember = new StringBuilder();
        insertMember.append("update book \n");
        insertMember.append("set title=?, author=?, price=?, content=? \n");
        insertMember.append("where isbn = ?");

        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(insertMember.toString());){
        	
            pstmt.setString(1, Book.getTitle());
            pstmt.setString(2, Book.getAuthor());
            pstmt.setInt(3, Book.getPrice());
            pstmt.setString(4, Book.getContent());
            pstmt.setString(5, Book.getIsbn());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int deleteArticle(String isbn) throws SQLException {
        StringBuilder insertMember = new StringBuilder();
        insertMember.append("delete from book \n");
        insertMember.append("where isbn = ?");

        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(insertMember.toString());){
        	
            pstmt.setString(1, isbn);
            return pstmt.executeUpdate();

        }
    }


	
}
