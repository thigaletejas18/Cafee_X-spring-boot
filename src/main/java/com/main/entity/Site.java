package com.main.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.main.base.BaseClass;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "Site")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Site extends BaseClass<String> {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="contactNumber")
	private long contactNumber;
	
	@Column(name="address")
	private String address;
	
	@Column(name="state")
	private String state;
	
	@Column(name="district")
	private String district;
	
	@Column(name="taluka")
	private String taluka;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip")
	private String zip;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenantId", nullable = false)
    private Tenant tenant;
  
	@JsonIgnore
	@OneToMany(mappedBy = "site")
	private List<UserInfo> users;
	
	@JsonIgnore
	@OneToMany(mappedBy = "site")
	private List<DiningTable> diningTables;
	
	@JsonIgnore
	@OneToMany(mappedBy = "site")
	private List<Ingredient> ingredients;
	
	@JsonIgnore
	@OneToMany(mappedBy = "site")
	private List<MenuItem> menuItems;
	

	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getTaluka() {
		return taluka;
	}


	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public Tenant getTenant() {
		return tenant;
	}


	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}


	public List<UserInfo> getUsers() {
		return users;
	}


	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}


	public List<DiningTable> getDiningTables() {
		return diningTables;
	}


	public void setDiningTables(List<DiningTable> diningTables) {
		this.diningTables = diningTables;
	}


	public List<Ingredient> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


	public List<MenuItem> getMenuItems() {
		return menuItems;
	}


	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

}
