package com.main.mapper;

public class IngredientMapper {

	private long id;
	
	private String name;
	
	private String description;
	
	private double quantity;
	
	private double minQuantity;
	
	private String unit;
	
	private double cost;
	
	private long siteId;
	
	private String siteName;
	
	private long tenantId;
	
	private String tenantName;

	public IngredientMapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public IngredientMapper(long id, String name, String description, double quantity, double minQuantity, String unit,
			double cost, long siteId, String siteName, long tenantId, String tenantName) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.minQuantity = minQuantity;
		this.unit = unit;
		this.cost = cost;
		this.siteId = siteId;
		this.siteName = siteName;
		this.tenantId = tenantId;
		this.tenantName = tenantName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(double minQuantity) {
		this.minQuantity = minQuantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public long getSiteId() {
		return siteId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public long getTenantId() {
		return tenantId;
	}

	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
}
