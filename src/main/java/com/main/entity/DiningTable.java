package com.main.entity;

import java.util.Date;
import java.util.List;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "DiningTable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiningTable extends BaseClass<String> {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column(name="tableNumber", nullable = false, unique = true)
	private long tableNumber;
	
	@Column(name="location")
	private String location;
	
	@Column(name="capacity")
	private int capacity;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "siteId", nullable = false)
    private Site site;


	public DiningTable() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getTableNumber() {
		return tableNumber;
	}


	public void setTableNumber(long tableNumber) {
		this.tableNumber = tableNumber;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}
	
}
