package com.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.main.DTO.RegistrationDTO;
import com.main.entity.MenuItem;
import com.main.entity.Site;
import com.main.entity.Tenant;
import com.main.entity.UserInfo;
import com.main.mapper.IngredientMapper;
import com.main.mapper.MenuItemMapper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.main.repository.MenuItemRepository;
import com.main.repository.SiteRepository;
import com.main.repository.TenantRepository;
import com.main.repository.UserInfoRepository;



@Service
public class MenuItemService {

	@Autowired
	MenuItemRepository menuItemRepo;
	
	@Autowired
	SiteRepository siteRepo;
	
	@Autowired
	AuthenticationService authService;
	
	public ResponseEntity<MenuItemMapper> createNewMenuItem(MenuItem menuItem){
		  if(authService.getSiteId() != null) {
			  Site site = siteRepo.findById(authService.getSiteId().get()).orElse(null);
			  menuItem.setSite(site);
			  MenuItem saved = this.menuItemRepo.save(menuItem);
				return ResponseEntity.ok(new MenuItemMapper(saved.getId(), saved.getName(), saved.getDescription(), saved.getcost(), saved.getAvailable(), saved.getImage(),  saved.getSite().getId(), saved.getSite().getName(), saved.getSite().getTenant().getId(), saved.getSite().getTenant().getName()));	
		  }
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	
		public ResponseEntity<List<MenuItemMapper>> getAll(){
			  if(authService.getSiteId() != null) {
				  List<MenuItem> data = this.menuItemRepo.findBySiteId(authService.getSiteId().get());
				  List<MenuItemMapper> response = new ArrayList<MenuItemMapper>();
				  for(MenuItem itr : data) {
					  response.add(new MenuItemMapper(itr.getId(), itr.getName(), itr.getDescription(), itr.getcost(), itr.getAvailable(), itr.getImage(), itr.getSite().getId(), itr.getSite().getName(), itr.getSite().getTenant().getId(), itr.getSite().getTenant().getName()));
				  }
				  return ResponseEntity.ok(response);	
			  }
			  return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
		public ResponseEntity<MenuItemMapper> find(long id){
			MenuItem item = menuItemRepo.findById(id).orElse(null);
			return item!=null ? 
					ResponseEntity.ok(new MenuItemMapper(item.getId(), item.getName(), item.getDescription(),  item.getcost(), item.getAvailable(), item.getImage() ,item.getSite().getId(), item.getSite().getName(), item.getSite().getTenant().getId(), item.getSite().getTenant().getName())) 
					: ResponseEntity.ok(null);
		}
	
	
	
}
