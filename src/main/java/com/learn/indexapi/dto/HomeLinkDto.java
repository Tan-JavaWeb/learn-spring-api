package com.learn.indexapi.dto;

import java.util.Collection;

import com.learn.indexapi.entities.HomeLinkDetailEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class HomeLinkDto extends BaseDto {

	private static final long serialVersionUID = 2768549182723743849L;

	private Long id;
	private String name;
	private Long sortOrder;
	private Collection<HomeLinkDetailEntity> listHomeLinkDetail;
}