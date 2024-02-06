package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Ingredient;
import com.main.entity.IngredientRequirement;

public interface IngredientRequirementRepository extends JpaRepository<IngredientRequirement, Long>{

}
