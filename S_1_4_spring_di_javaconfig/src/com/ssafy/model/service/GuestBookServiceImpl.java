package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.GuestBookDto;
import com.ssafy.model.dao.GuestBookDao;

@Service(value = "gbService")
public class GuestBookServiceImpl implements GuestBookService {
    
    private GuestBookDao guestBookDao;
    
    @Autowired
    public void setGuestBookDao(GuestBookDao guestBookDao) {
        this.guestBookDao = guestBookDao;
    }

    @Override
    public void writeArticle(GuestBookDto guestBookDto) throws Exception {
        if(guestBookDto.getSubject() == null || guestBookDto.getContent() == null) {
            throw new Exception();
        }
        guestBookDao.writeArticle(guestBookDto);
    }

    @Override
    public List<GuestBookDto> listArticle() throws Exception {
        return guestBookDao.listArticle();
    }

    @Override
    public GuestBookDto getArticle(int articleno) throws Exception {
        return guestBookDao.getArticle(articleno);
    }

    @Override
    public void modifyArticle(GuestBookDto guestBookDto) throws Exception {
        guestBookDao.modifyArticle(guestBookDto);
    }

    @Override
    public void deleteArticle(int articleno) throws Exception {
        guestBookDao.deleteArticle(articleno);
    }

}
