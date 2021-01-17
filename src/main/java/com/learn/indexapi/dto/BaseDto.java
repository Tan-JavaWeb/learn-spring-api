package com.learn.indexapi.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BaseDto implements Serializable {
	private static final long serialVersionUID = -5107159736460129694L;
	
	private Date createdAt;
	private Date updatedAt;
}
