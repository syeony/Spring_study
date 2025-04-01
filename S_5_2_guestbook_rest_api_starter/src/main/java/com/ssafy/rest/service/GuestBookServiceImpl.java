package com.ssafy.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.rest.dao.GuestBookDao;
import com.ssafy.rest.dto.GuestBookDto;

@Service
public class GuestBookServiceImpl implements GuestBookService{
    
//	@Autowired
	GuestBookDao dao;
	GuestBookServiceImpl(GuestBookDao dao){
		this.dao=dao;
	}
	
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

	@Override
	public int writeArticle(GuestBookDto dto) {
		int result = -1;
        result = dao.writeArticle(dto);
		return result;
	}

	@Override
	public int updateArticle(GuestBookDto dto) {
		int result = -1;
        result = dao.updateArticle(dto);

		return result;
	}

	@Override
	public int deleteArticle(int articleno) {
		int result = -1;
        result = dao.deleteArticle(articleno);

		return result;
	}
}
