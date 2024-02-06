package com.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.main.DTO.RegistrationDTO;
import com.main.entity.Site;
import com.main.entity.Tenant;
import com.main.entity.UserInfo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.main.repository.SiteRepository;
import com.main.repository.TenantRepository;
import com.main.repository.UserInfoRepository;



@Service
public class TenantService {

	@Autowired
	UserInfoRepository userRepo;
	
	@Autowired
	TenantRepository tenantRepo;
	
    @Autowired
    SiteRepository siteRepo;
	
	@Autowired
    private PasswordEncoder encoder;
}
