package com.learn.indexapi.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DemoDto implements Serializable{
	
	private static final long serialVersionUID = -3125002027423420446L;

	private Long id;
	
	private String name;
}