package com.main.base;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseClass<String> {

	@CreatedBy
	@Column(name="createdBy", nullable = false, updatable = false)
	protected String createdBy;
	
	@LastModifiedBy
	@Column(name="updatedBy")
	protected String updatedBy;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createDate", nullable = false, updatable = false)
	protected Date createDate;
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updateDate")
	protected Date updateDate;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
