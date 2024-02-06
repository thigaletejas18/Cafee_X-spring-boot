package com.main.service;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.main.entity.UserInfoDetails;

@Service
public class AuthenticationService {
	
    public Optional<Long> getSiteId() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserInfoDetails user = (UserInfoDetails) authentication.getPrincipal();
    	return user != null ? Optional.of(user.getSiteId()) : Optional.of(null);
    }
    
    public Optional<Long> getUserId() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserInfoDetails user = (UserInfoDetails) authentication.getPrincipal();
		return user != null ? Optional.of(user.getId()) : Optional.of(null);
    }
}
