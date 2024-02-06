package com.main.jpaAuditing;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomAuditorAware implements org.springframework.data.domain.AuditorAware<String> {
@Override
    public Optional<String> getCurrentAuditor() {
	   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	   if(authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails){
		   return Optional.of(((UserDetails) authentication.getPrincipal()).getUsername());
	   }
	   else {
		   return Optional.of("SYSTEM");
	   }
    }
}
