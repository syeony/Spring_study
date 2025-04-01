package com.ssafy.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.guestbook.dto.GuestBookDto;

@Repository
public class GuestBookDaoImpl implements GuestBookDao {

    @Autowired
    private DataSource dataSource;
    

    @Override
    public List<GuestBookDto> listArticle() throws SQLException {
        List<GuestBookDto> list = new ArrayList<GuestBookDto>();

        StringBuilder sql = new StringBuilder();
        sql.append("select articleno, userid, subject, content, regtime \n");
        sql.append("from guestbook \n");
        sql.append("order by articleno desc");
        
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql.toString());){

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                GuestBookDto guestBookDto = new GuestBookDto();
                guestBookDto.setArticleno(rs.getInt("articleno"));
                guestBookDto.setUserid(rs.getString("userid"));
                guestBookDto.setSubject(rs.getString("subject"));
                guestBookDto.setContent(rs.getString("content"));
                guestBookDto.setRegtime(rs.getString("regtime"));
                
                list.add(guestBookDto);
            }
        }
        
        return list;
    }

    
    @Override
    public GuestBookDto getArticle(int articleno) throws SQLException {
        GuestBookDto guestBookDto = null;
        
        StringBuilder sql = new StringBuilder();
        sql.append("select articleno, userid, subject, content, regtime \n");
        sql.append("from guestbook \n");
        sql.append("where articleno = ?");
        
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
        	
            pstmt.setInt(1, articleno);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                guestBookDto = new GuestBookDto();
                guestBookDto.setArticleno(rs.getInt("articleno"));
                guestBookDto.setUserid(rs.getString("userid"));
                guestBookDto.setSubject(rs.getString("subject"));
                guestBookDto.setContent(rs.getString("content"));
                guestBookDto.setRegtime(rs.getString("regtime"));
            }
        }

        return guestBookDto;
    }

    
    @Override
    public int writeArticle(GuestBookDto guestBookDto) throws SQLException {
        StringBuilder insertMember = new StringBuilder();
        insertMember.append("insert into guestbook (userid, subject, content, regtime) \n");
        insertMember.append("values (?, ?, ?, now())");

        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(insertMember.toString());){
        	
            pstmt.setString(1, guestBookDto.getUserid());
            pstmt.setString(2, guestBookDto.getSubject());
            pstmt.setString(3, guestBookDto.getContent());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int updateArticle(GuestBookDto guestBookDto) throws SQLException {
        StringBuilder insertMember = new StringBuilder();
        insertMember.append("update guestbook \n");
        insertMember.append("set subject = ?, content = ? \n");
        insertMember.append("where articleno = ?");

        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(insertMember.toString());){
        	
            pstmt.setString(1, guestBookDto.getSubject());
            pstmt.setString(2, guestBookDto.getContent());
            pstmt.setInt(3, guestBookDto.getArticleno());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int deleteArticle(int articleno) throws SQLException {
        StringBuilder insertMember = new StringBuilder();
        insertMember.append("delete from guestbook \n");
        insertMember.append("where articleno = ?");

        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(insertMember.toString());){
        	
            pstmt.setInt(1, articleno);
            return pstmt.executeUpdate();

        }
    }

}
