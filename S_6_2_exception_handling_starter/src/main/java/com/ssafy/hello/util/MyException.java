package com.ssafy.hello.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class MyException extends RuntimeException {
	private String code;
	
	public MyException(String code, String msg) {
		super(msg); //메시지는 런타임에 넘겨주고
		this.code=code; //코드는 내가 갖고 있고 
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
