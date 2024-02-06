package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.main.DTO.AuthenticatedDTO;
import com.main.DTO.AuthorizationDTO;
import com.main.DTO.RegistrationDTO;
import com.main.entity.UserInfo;
import com.main.entity.UserInfoDetails;
import com.main.service.JwtService;
import com.main.service.UserInfoService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@RestController
@RequestMapping("/api/user")
public class UserInfoController {

	@Autowired
	UserInfoService userService;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	@PostMapping("/new")
	public ResponseEntity<UserInfo> createNewUser(@RequestBody UserInfo user) {
		return this.userService.createUser(user);
	}
	
	@PostMapping("/authenticate") 
    public ResponseEntity<AuthenticatedDTO> authenticateAndGetToken(@RequestBody AuthorizationDTO authRequest) { 
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
        if (authentication.isAuthenticated()) { 
        	UserInfoDetails userInfo = (UserInfoDetails) authentication.getPrincipal();
        	String token = jwtService.generateToken(authRequest.getUsername());
            return ResponseEntity.ok(new AuthenticatedDTO(token, userInfo)); 
        } else { 
            throw new UsernameNotFoundException("invalid user request !"); 
        } 
    } 
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<UserInfo> getUser(@PathVariable long id){
		return ResponseEntity.ok(this.userService.getUser(id));
	}
	
	@GetMapping("/check-email-availability")
	public ResponseEntity<Boolean> checkEmailAvailability(@RequestParam String email) {
		if(email == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		else {
			return ResponseEntity.ok(this.userService.chkEmailAvailability(email));	
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<Boolean> registerNewUser(@RequestBody RegistrationDTO registrationDto){
		if(registrationDto.getTenant() != null && registrationDto.getUserInfo() != null) {
			return this.userService.registerUserWithTenant(registrationDto);	
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
