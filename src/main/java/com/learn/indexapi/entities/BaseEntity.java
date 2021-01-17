package com.learn.indexapi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 4918906171006502033L;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty(value = "createdAt", access = Access.WRITE_ONLY)
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty(value = "updatedAt", access = Access.WRITE_ONLY)
	@UpdateTimestamp
	private Date updatedAt;
}