package com.main.DTO;

import com.main.entity.UserInfoDetails;

public class AuthenticatedDTO {

	private UserInfoDetails userInfoDetails;
	
	private String jwtToken;
	

	public AuthenticatedDTO(String jwtToken, UserInfoDetails userInfoDetails) {
		super();
		this.userInfoDetails = userInfoDetails;
		this.jwtToken = jwtToken;
	}

	public AuthenticatedDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfoDetails getUserInfoDetails() {
		return userInfoDetails;
	}

	public void setUserInfoDetails(UserInfoDetails userInfoDetails) {
		this.userInfoDetails = userInfoDetails;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
}
