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
import com.main.entity.UserInfoDetails;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.main.repository.SiteRepository;
import com.main.repository.TenantRepository;
import com.main.repository.UserInfoRepository;



@Service
public class UserInfoService implements UserDetailsService {

	@Autowired
	UserInfoRepository userRepo;
	
	@Autowired
	TenantRepository tenantRepo;
	
    @Autowired
    SiteRepository siteRepo;
	
	@Autowired
    private PasswordEncoder encoder;
	
	public ResponseEntity<UserInfo> createUser(UserInfo user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		return ResponseEntity.ok(this.userRepo.save(user));
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		  
        Optional<UserInfo> userDetail = this.userRepo.findByEmail(username); 
        // Converting userDetail to UserDetails 
        return userDetail.map(UserInfoDetails::new) 
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
    } 
	
	public UserInfo getUser(long id) {
		UserInfo user = this.userRepo.findById(id).orElse(null);
		return user;
	}
	
	public boolean chkEmailAvailability(String email){
		UserInfo user = this.userRepo.findByEmail(email).orElse(null);
		if(user == null) {
		  return true;
		}
		else {
		  return false;	
		}
	}
	
	public ResponseEntity<Boolean> registerUserWithTenant(RegistrationDTO registrationDto) {
		Tenant tenant = this.tenantRepo.save(registrationDto.getTenant());
		Site site = new Site();
		site.setName("Default Site Location");
		site.setContactNumber(tenant.getContactNumber());
		site.setAddress(tenant.getAddress());
		site.setTenant(tenant);
		Site savedSite = this.siteRepo.save(site);
		UserInfo userInfo = registrationDto.getUserInfo();
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		userInfo.setSite(savedSite);
		userInfo.setRoles("ROLE_ADMIN");
		this.userRepo.save(userInfo);
		return ResponseEntity.ok(true);
	}
	
}
