package com.learn.indexapi.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "link_home_pages")
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class LinkHomePage extends BaseEntity {

	private static final long serialVersionUID = -8190258999642793140L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "sort_order")
	private Long sortOrder;

	@OneToMany(mappedBy = "linkHomePage")
	private Collection<LinkHomePageDetail> listLinkHomePageDetail;
}