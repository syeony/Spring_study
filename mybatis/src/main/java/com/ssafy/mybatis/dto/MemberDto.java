package com.ssafy.mybatis.dto;

import java.util.List;

public class MemberDto {
	private String userid;
	private String username;
	private String address;
	private String email;
	
	private List<GuestBookDto> guestBookDtoList;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<GuestBookDto> getGuestBookDtoList() {
		return guestBookDtoList;
	}

	public void setGuestBookDtoList(List<GuestBookDto> guestBookDtoList) {
		this.guestBookDtoList = guestBookDtoList;
	}
	
	
}
