package com.main.DTO;

import com.main.entity.Tenant;
import com.main.entity.UserInfo;

public class RegistrationDTO {

	private UserInfo userInfo;
	
	private Tenant tenant;

	public RegistrationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
}
