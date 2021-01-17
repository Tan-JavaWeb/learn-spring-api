package com.learn.indexapi.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.indexapi.dto.DemoDto;
import com.learn.indexapi.dto.LinkHomePageDetailDto;
import com.learn.indexapi.dto.LinkHomePageDto;
import com.learn.indexapi.entities.Demo;
import com.learn.indexapi.entities.LinkHomePage;
import com.learn.indexapi.entities.LinkHomePageDetail;

@Service
public class MapperService {
	
	@Autowired
	private ModelMapper mapper;

	public DemoDto mapDemoToDto(Demo demoEntity) {
		return mapper.map(demoEntity, DemoDto.class);
	}
	
	public LinkHomePageDto mapLinkHomePageToDto(LinkHomePage linkHomePage) {
		return mapper.map(linkHomePage, LinkHomePageDto.class);
	}
	
	public LinkHomePageDetailDto mapLinkHomePageDetailToDto(LinkHomePageDetail linkHomePageDetail) {
		return mapper.map(linkHomePageDetail, LinkHomePageDetailDto.class);
	}
}