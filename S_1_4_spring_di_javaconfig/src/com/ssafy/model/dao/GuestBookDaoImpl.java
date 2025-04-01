package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.GuestBookDto;
import com.ssafy.util.DBUtil;

@Repository
public class GuestBookDaoImpl implements GuestBookDao {
    
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void writeArticle(GuestBookDto guestBookDto) throws SQLException {
        StringBuilder insertQuery = new StringBuilder();
        insertQuery.append("insert into guestbook (userid, subject, content) \n");
        insertQuery.append("values (?, ?, ?)");

        try (Connection conn = dataSource.getConnection();
        		PreparedStatement pstmt = conn.prepareStatement(insertQuery.toString());) {

            pstmt.setString(1, guestBookDto.getUserid());
            pstmt.setString(2, guestBookDto.getSubject());
            pstmt.setString(3, guestBookDto.getContent());
            pstmt.executeUpdate();

        }
    }

    @Override
    public List<GuestBookDto> listArticle() throws SQLException {
        List<GuestBookDto> list = new ArrayList<GuestBookDto>();
        
        StringBuilder sql = new StringBuilder();
        sql.append("select articleno, userid, subject, content, regtime \n");
        sql.append("from guestbook \n");
        sql.append("order by articleno desc \n");
        
        try (Connection conn = dataSource.getConnection();
        		PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

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
                PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
            
            pstmt.setInt(1, articleno);
            ResultSet  rs = pstmt.executeQuery();

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
    public void modifyArticle(GuestBookDto guestBookDto) throws SQLException {
        StringBuilder updateQuery = new StringBuilder();
        updateQuery.append("update guestbook \n");
        updateQuery.append("set subject = ?, content = ? \n");
        updateQuery.append("where articleno = ?");

        try (Connection conn = dataSource.getConnection();
        		PreparedStatement pstmt = conn.prepareStatement(updateQuery.toString());){

        	pstmt.setString(1, guestBookDto.getSubject());
            pstmt.setString(2, guestBookDto.getContent());
            pstmt.setInt(3, guestBookDto.getArticleno());
            
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteArticle(int articleno) throws SQLException {
        StringBuilder deleteQuery = new StringBuilder();
        deleteQuery.append("delete from guestbook \n");
        deleteQuery.append("where articleno = ?");

        try (Connection conn = dataSource.getConnection();
        		PreparedStatement pstmt = conn.prepareStatement(deleteQuery.toString());){

        	pstmt.setInt(1, articleno);
            pstmt.executeUpdate();
        }
    }

}
