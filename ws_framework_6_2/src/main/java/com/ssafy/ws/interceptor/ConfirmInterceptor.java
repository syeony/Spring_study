package com.ssafy.ws.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ConfirmInterceptor implements HandlerInterceptor{
	
	private static final Logger log = LoggerFactory.getLogger(ConfirmInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String cookieName=null;
		Cookie [] cookies=request.getCookies();
		
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				log.debug("cookieName:{}",cookie.getName());
				log.debug("getValue:{}",cookie.getValue());
				
				cookieName=cookie.getName();
			}
		}
		
		if(cookieName==null || !"id".equals(cookieName)) {
			response.sendRedirect("/");
			return false; //controller를 수행하지 않음.
		}
		return true;
//		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
