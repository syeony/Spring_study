package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.ws.interceptor.ConfirmInterceptor;

public class WebConfiguration implements WebMvcConfigurer{
	
	@Autowired
	ConfirmInterceptor intercepter;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.addInterceptors(registry);
		registry
		.addInterceptor(intercepter)
		.addPathPatterns("/writeArticle");
	}
}
