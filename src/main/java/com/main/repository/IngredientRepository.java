package com.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{
	
   public List<Ingredient> findBySiteId(long id);
}
