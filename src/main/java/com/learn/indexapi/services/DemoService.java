package com.learn.indexapi.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.indexapi.dto.DemoDto;
import com.learn.indexapi.entities.Demo;
import com.learn.indexapi.repositories.IDemoRepository;

@Service
public class DemoService {
	
	private static final Logger log = LoggerFactory.getLogger(DemoService.class);
	
	@Autowired
	private IDemoRepository demoRepository;
	
	@Autowired
	private MapperService mapperService;
	
	public List<DemoDto> getAll(){
		List<Demo> demos = demoRepository.findAll();
		List<DemoDto> demoDtos = new ArrayList<DemoDto>();
		
		for(Demo demo: demos) {
			demoDtos.add(mapperService.mapDemoToDto(demo));
		}
		
		return demoDtos;
	}

}