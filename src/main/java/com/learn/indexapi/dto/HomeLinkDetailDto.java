package com.learn.indexapi.dto;

import com.learn.indexapi.entities.HomeLinkEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class HomeLinkDetailDto extends BaseDto {

	private static final long serialVersionUID = 342381048058386575L;

	private Long id;
	private String name;
	private Long sortOrder;
	private HomeLinkEntity homeLinkEntity;
}
