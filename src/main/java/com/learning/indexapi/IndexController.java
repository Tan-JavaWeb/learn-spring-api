package com.learning.indexapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@Autowired
	private DemoRepository repository;
	
	@GetMapping("/")
	public List<Demo> index() {
		List<Demo> list = repository.findAll();
		return list;
	}
}
