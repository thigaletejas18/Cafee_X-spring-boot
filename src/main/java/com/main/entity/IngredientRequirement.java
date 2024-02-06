package com.main.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.main.base.BaseClass;
import com.main.enums.DiningTableStatus;
import com.main.enums.QuantityUnit;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "IngredientRequirement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientRequirement extends BaseClass<String> {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "menuitem_id")
    private MenuItem menuItem;
	
	@ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
	
	private double requiredQty;



	public IngredientRequirement() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public MenuItem getMenuItem() {
		return menuItem;
	}



	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}



	public Ingredient getIngredient() {
		return ingredient;
	}



	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}



	public double getRequiredQty() {
		return requiredQty;
	}



	public void setRequiredQty(double requiredQty) {
		this.requiredQty = requiredQty;
	}

}
