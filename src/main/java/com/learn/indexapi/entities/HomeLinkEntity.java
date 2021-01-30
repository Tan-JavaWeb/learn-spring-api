package com.learn.indexapi.entities;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.learn.indexapi.constant.SequenceConst;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "home_links")
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class HomeLinkEntity extends BaseEntity {

	private static final long serialVersionUID = -8190258999642793140L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SequenceConst.SEQUENCE_HOME_LINK_ID)
	@SequenceGenerator(name = SequenceConst.SEQUENCE_HOME_LINK_ID, sequenceName = SequenceConst.SEQUENCE_HOME_LINK_ID,
	      allocationSize = 1,initialValue=1)
	@Basic(optional = false)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "sort_order")
	private Long sortOrder;

	@OneToMany(mappedBy = "home_link")
	private Collection<HomeLinkDetailEntity> listHomeLinkDetail;
}