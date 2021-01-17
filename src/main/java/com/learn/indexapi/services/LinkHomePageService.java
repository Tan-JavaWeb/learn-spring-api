package com.learn.indexapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.indexapi.dto.LinkHomePageDto;
import com.learn.indexapi.entities.LinkHomePage;
import com.learn.indexapi.repositories.ILinkHomePageRepository;

@Service
public class LinkHomePageService {
	
	@Autowired
	private ILinkHomePageRepository homePageRepository;
	
	@Autowired
	private MapperService mapperService;
	
	public List<LinkHomePageDto> getAll(){
		List<LinkHomePage> listEntities = homePageRepository.findAll();
		List<LinkHomePageDto> listDtos = new ArrayList<LinkHomePageDto>();
		
		for (LinkHomePage entity : listEntities) {
			listDtos.add(mapperService.mapLinkHomePageToDto(entity));
		}
		
		return listDtos;
	}
}
