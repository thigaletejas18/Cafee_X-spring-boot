package com.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.main.DTO.RegistrationDTO;
import com.main.entity.Ingredient;
import com.main.entity.Site;
import com.main.entity.Tenant;
import com.main.entity.UserInfo;
import com.main.entity.UserInfoDetails;
import com.main.mapper.IngredientMapper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.main.repository.IngredientRepository;
import com.main.repository.SiteRepository;
import com.main.repository.TenantRepository;
import com.main.repository.UserInfoRepository;



@Service
public class IngredientService {

	@Autowired
	IngredientRepository ingredientRepo;
	
	@Autowired
	TenantRepository tenantRepo;
	
    @Autowired
    SiteRepository siteRepo;
    
    @Autowired
    AuthenticationService authService;
	
	@Autowired
    private PasswordEncoder encoder;
	
	public ResponseEntity<IngredientMapper> createNewIngredient(Ingredient ingredient){
	  if(authService.getSiteId() != null) {
		  Site site = siteRepo.findById(authService.getSiteId().get()).orElse(null);
		  ingredient.setSite(site);
		  Ingredient saved = this.ingredientRepo.save(ingredient);
			return ResponseEntity.ok(new IngredientMapper(saved.getId(), saved.getName(), saved.getDescription(), saved.getQuantity(),saved.getMinQuantity(),
					saved.getUnit(), saved.getcost(), saved.getSite().getId(), saved.getSite().getName(), saved.getSite().getTenant().getId(), saved.getSite().getTenant().getName()));	
	  }
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	public ResponseEntity<List<IngredientMapper>> getAll(){
		  if(authService.getSiteId() != null) {
			  List<Ingredient> data = this.ingredientRepo.findBySiteId(authService.getSiteId().get());
			  List<IngredientMapper> response = new ArrayList<IngredientMapper>();
			  for(Ingredient itr : data) {
				  response.add(new IngredientMapper(itr.getId(), itr.getName(), itr.getDescription(), itr.getQuantity(),itr.getMinQuantity(),
						  itr.getUnit(), itr.getcost(), itr.getSite().getId(), itr.getSite().getName(), itr.getSite().getTenant().getId(), itr.getSite().getTenant().getName()));
			  }
			  return ResponseEntity.ok(response);	
		  }
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	public ResponseEntity<IngredientMapper> find(long id){
		Ingredient ing = ingredientRepo.findById(id).orElse(null);
		return ing!=null ? 
				ResponseEntity.ok(new IngredientMapper(ing.getId(), ing.getName(), ing.getDescription(), ing.getQuantity(),ing.getMinQuantity(),
						ing.getUnit(), ing.getcost(), ing.getSite().getId(), ing.getSite().getName(), ing.getSite().getTenant().getId(), ing.getSite().getTenant().getName())) 
				: ResponseEntity.ok(null);
	}
	
}
