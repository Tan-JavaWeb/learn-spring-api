package com.learn.indexapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.indexapi.entities.Demo;
import com.learn.indexapi.repositories.IDemoRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class IndexController {
	
	@Autowired
	private IDemoRepository repository;
	
	@GetMapping("/")
	public List<Demo> index() {
		List<Demo> list = repository.findAll();
		return list;
	}
}
