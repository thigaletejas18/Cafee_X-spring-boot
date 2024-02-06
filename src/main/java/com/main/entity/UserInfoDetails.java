package com.main.entity;


import org.springframework.security.core.GrantedAuthority; 
import org.springframework.security.core.authority.SimpleGrantedAuthority; 
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays; 
import java.util.Collection; 
import java.util.List; 
import java.util.stream.Collectors;

public class UserInfoDetails implements UserDetails { 

	private long id;
	
	private String username;

	private String email;
	
	private String password;
	
	private List<GrantedAuthority> authorities;
    
	private String firstName;
	
	private String lastName;
	
	private long mobileNumber;
	
	private long siteId;
	
	private String siteName;
	
	private long tenantId;
	
	private String tenantName; 
	 

	public UserInfoDetails(UserInfo userInfo) {
		id = userInfo.getId();
		email = username = userInfo.getEmail(); 
		password = userInfo.getPassword(); 
		authorities = Arrays.stream(userInfo.getRoles().split(",")) 
				.map(SimpleGrantedAuthority::new) 
				.collect(Collectors.toList()); 
		firstName = userInfo.getFirstName();
		lastName = userInfo.getLastName();
		mobileNumber = userInfo.getMobileNumber();
		siteId = userInfo.getSite().getId();
		siteName = userInfo.getSite().getName();
		tenantId = userInfo.getSite().getTenant().getId();
		tenantName = userInfo.getSite().getTenant().getName();
	} 

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { 
		return authorities; 
	} 

	@Override
	public String getPassword() { 
		return password; 
	} 

	@Override
	public String getUsername() { 
		return username; 
	} 

	@Override
	public boolean isAccountNonExpired() { 
		return true; 
	} 

	@Override
	public boolean isAccountNonLocked() { 
		return true; 
	} 

	@Override
	public boolean isCredentialsNonExpired() { 
		return true; 
	} 

	@Override
	public boolean isEnabled() { 
		return true; 
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public long getTenantId() {
		return tenantId;
	}

	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 
	
} 

