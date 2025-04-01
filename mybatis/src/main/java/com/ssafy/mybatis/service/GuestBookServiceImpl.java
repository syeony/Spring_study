package com.ssafy.mybatis.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mybatis.dto.GuestBookDto;
import com.ssafy.mybatis.dto.MemberDto;
import com.ssafy.mybatis.mapper.GuestBookMapper;

@Service
public class GuestBookServiceImpl implements GuestBookService {
	
	
	private static final Logger log = LoggerFactory.getLogger(GuestBookServiceImpl.class);

	@Autowired
	GuestBookMapper mapper;
	
	@Override
	public GuestBookDto selectGuestBook(int id) {
		return mapper.selectGuestBook(id);
	}

	@Override
	@Transactional // 전체 commit 혹은 전체 rollback(RuntimeException발생시)처리한다. 
	public int writeGuestBook(GuestBookDto dto) {
		int result=mapper.writeGuestBook(dto);
		return result;
	}
	
	public List<GuestBookDto> selectByUser(String userid){
		
		//로직 수행...
		
		return mapper.selectByUser(userid);
	}
	
	@Override
	public MemberDto selectUserGuestBook(String userid) {
		MemberDto dto = mapper.selectUser(userid); //master 조회.
		List<GuestBookDto> gList = mapper.selectByUser(userid); //detail 조회. 
		
		dto.setGuestBookDtoList(gList);
		
		return dto;
	}

}
