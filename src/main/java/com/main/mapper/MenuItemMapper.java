package com.main.mapper;

public class MenuItemMapper {

	private long id;
	
	private String name;
	
	private String description;
	
	private double cost;

	private boolean available;

	private String image;
	
	private long siteId;
	
	private String siteName;
	
	private long tenantId;
	
	private String tenantName;

	public MenuItemMapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	


	public MenuItemMapper(long id, String name, String description, double cost, boolean available, String image,
			long siteId, String siteName, long tenantId, String tenantName) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.available = available;
		this.image = image;
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

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean getAvailbale() {
		return available;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
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
