package com.main.entity;

import java.util.ArrayList;
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
@Table(name= "Ingredient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient extends BaseClass<String> {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
//	@Column(name="ingredientId", nullable = false, unique = true)
//	private long ingredientId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="minQuantity")
	private double minQuantity;
	
	@Column(name="quantity")
	private double quantity;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name="cost")
	private double cost;
	
	@Column(name="image")
	private String image;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ingredient")
    private List<IngredientRequirement> ingredientRequirements = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "siteId", nullable = false)
    private Site site;


	public Ingredient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


//	public long getIngredientId() {
//		return ingredientId;
//	}
//
//
//	public void setIngredientId(long ingredientId) {
//		this.ingredientId = ingredientId;
//	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getMinQuantity() {
		return minQuantity;
	}


	public void setMinQuantity(double minQuantity) {
		this.minQuantity = minQuantity;
	}


	public double getQuantity() {
		return quantity;
	}


	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public double getcost() {
		return cost;
	}


	public void setcost(double cost) {
		this.cost = cost;
	}


	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}

}
