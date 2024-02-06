package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import com.main.DTO.AuthenticatedDTO;
import com.main.DTO.AuthorizationDTO;
import com.main.DTO.RegistrationDTO;
import com.main.entity.Ingredient;
import com.main.entity.UserInfo;
import com.main.entity.UserInfoDetails;
import com.main.mapper.IngredientMapper;
import com.main.repository.IngredientRepository;
import com.main.service.IngredientService;
import com.main.service.JwtService;
import com.main.service.UserInfoService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

	@Autowired
	IngredientService ingredientService;
	
	
	@PostMapping("/new") 
    public ResponseEntity<IngredientMapper> createNew(@RequestBody Ingredient ingredient) { 
        return ingredientService.createNewIngredient(ingredient);
    } 
	
	@GetMapping("/all")
	public ResponseEntity<List<IngredientMapper>> get(){
		return ingredientService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<IngredientMapper> find(@PathVariable long id){
		return ingredientService.find(id);
	}
}
