package com.ssafy.ws.util;

public class InvalidNumberFormatException extends RuntimeException{
	private String code;
	
	public InvalidNumberFormatException(String code, String msg) {
		super(msg);
		this.code=code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
