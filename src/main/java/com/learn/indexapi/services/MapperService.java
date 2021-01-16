package com.learn.indexapi.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.indexapi.dto.DemoDto;
import com.learn.indexapi.entities.Demo;

@Service
public class MapperService {
	
	@Autowired
	private ModelMapper mapper;

	public DemoDto mapDemoToDto(Demo demoEntity) {
		return mapper.map(demoEntity, DemoDto.class);
	}
}