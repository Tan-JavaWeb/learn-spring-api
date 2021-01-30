package com.learn.indexapi.utils;

public class CustomMessages {
	
	public static String ShowMessage(String message, String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			message = message.replace("{" + i +  "}", args[i]);
		}
		
		return message;
	}
}
