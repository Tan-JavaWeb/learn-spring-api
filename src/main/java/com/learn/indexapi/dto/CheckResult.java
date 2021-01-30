package com.learn.indexapi.dto;

import java.util.Map;

import lombok.Data;

@Data
public class CheckResult {
	private boolean result;
	private Map<String, String> messgaes;
	
	public CheckResult() {
		this.result = false;
	}
}
