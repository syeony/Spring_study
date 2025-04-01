package com.ssafy.ws.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.ws.util.InvalidNumberFormatException;

@ControllerAdvice
public class ExceptionController {
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(final Exception e) {
		ModelAndView mv=new ModelAndView();
		
		if(e instanceof org.springframework.validation.BindException) {
			mv.addObject("msg", "파라미터가 잘 전달되었는지 확인하세요.");
		}else{
			mv.addObject("msg", "알 수 없는 오류가 발생하였습니다. 잠시 뒤 시도해 주세요.");
		}
		
		mv.setViewName("/error/commonerr");
		return mv;
	}
	
	@ExceptionHandler(DuplicateKeyException.class)
	public ModelAndView myError(final DuplicateKeyException e) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("msg", "입력된 ISBN과 동일한 ISBN이 존재합니다.");
		mv.setViewName("/error/commonerr");
		
		return mv;
	}
}
