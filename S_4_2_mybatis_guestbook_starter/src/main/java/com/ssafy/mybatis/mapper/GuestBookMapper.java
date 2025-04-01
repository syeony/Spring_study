package com.ssafy.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mybatis.dto.GuestBookDto;

/* 글 쓰기, 수정, 삭제를 구현해보자. */

@Mapper
public interface GuestBookMapper {

    public List<GuestBookDto> listArticle();
    public GuestBookDto getArticle(int articleno);

    
}
