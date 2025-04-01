package com.ssafy.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.guestbook.dao.GuestBookDao;
import com.ssafy.guestbook.dto.GuestBookDto;

@Service
public class GuestBookServiceImpl implements GuestBookService {
    
    @Autowired
    private GuestBookDao guestBookDao;

    @Override
    public List<GuestBookDto> listArticle() throws Exception {
        return guestBookDao.listArticle();
    }

    @Override
    public GuestBookDto getArticle(int articleno) throws Exception {
        return guestBookDao.getArticle(articleno);
    }

    @Override
    public int writeArticle(GuestBookDto guestBookDto) throws Exception {
        if(guestBookDto.getSubject() == null || guestBookDto.getContent() == null) {
            throw new Exception();
        }

        return guestBookDao.writeArticle(guestBookDto);
    }

    @Override
    public int updateArticle(GuestBookDto guestBookDto) throws Exception {
        return guestBookDao.updateArticle(guestBookDto);
    }

    @Override
    public int deleteArticle(int articleno) throws Exception {
        return guestBookDao.deleteArticle(articleno);
    }

}
