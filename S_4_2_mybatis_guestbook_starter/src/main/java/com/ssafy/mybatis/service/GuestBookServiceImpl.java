package com.ssafy.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mybatis.dto.GuestBookDto;
import com.ssafy.mybatis.mapper.GuestBookMapper;


/* 글 쓰기, 수정, 삭제를 구현해보자.*/


@Service
public class GuestBookServiceImpl implements GuestBookService{
    
	@Autowired
	GuestBookMapper dao;
	
	@Override
	public List<GuestBookDto> listArticle() {

        List<GuestBookDto> dtoList = dao.listArticle();
        return dtoList;
	}

	@Override
	public GuestBookDto getArticle(int articleno) {

        GuestBookDto dto = dao.getArticle(articleno);
      
        return dto;

	}

	//=======================================
	
    @Override
    public int writeArticle(GuestBookDto guestBookDto) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateArticle(GuestBookDto guestBookDto) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteArticle(int articleno) {
        // TODO Auto-generated method stub
        return 0;
    }

	
}
