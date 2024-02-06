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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "MenuItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem extends BaseClass<String> {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column(name="itemNumber")//nullable = false, unique = true
	private long itemNumber;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="cost")
	private double cost;
	
	@Column(name="available")
	private boolean available;
	
	@Column(name="image")
	private String image;
	
	@JsonIgnore
	@OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IngredientRequirement> ingredientRequirements = new ArrayList<>();
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "siteId", nullable = false)
    private Site site;


	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}



	public List<IngredientRequirement> getIngredientRequirements() {
		return ingredientRequirements;
	}


	public void setIngredientRequirements(List<IngredientRequirement> ingredientRequirements) {
		this.ingredientRequirements = ingredientRequirements;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getItemNumber() {
		return itemNumber;
	}


	public void setItemNumber(long itemNumber) {
		this.itemNumber = itemNumber;
	}


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


	public double getcost() {
		return cost;
	}


	public void setcost(double cost) {
		this.cost = cost;
	}


	public boolean getAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}


	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}



	public double getCost() {
		return cost;
	}



	public void setCost(double cost) {
		this.cost = cost;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}
	
	

}
