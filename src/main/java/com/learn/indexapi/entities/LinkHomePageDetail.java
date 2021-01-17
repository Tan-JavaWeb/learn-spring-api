package com.learn.indexapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "link_home_page_details")
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class LinkHomePageDetail extends BaseEntity {
	private static final long serialVersionUID = -6920388752121714720L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "sort_order")
	private Long sortOrder;

	@ManyToOne
    @JoinColumn(name = "link_home_page_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("link_home_page_id")
	private LinkHomePage linkHomePage;
}