package com.learn.indexapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.indexapi.dto.LinkHomePageDetailDto;
import com.learn.indexapi.entities.LinkHomePageDetail;
import com.learn.indexapi.repositories.ILinkHomePageDetailRepository;

@Service
public class LinkHomePageDetailService {
	
	@Autowired
	private ILinkHomePageDetailRepository detailRepository;
	
	@Autowired
	private MapperService mapperService;
	
	public List<LinkHomePageDetailDto> getAll(){
		List<LinkHomePageDetail> listEntities = detailRepository.findAll();
		List<LinkHomePageDetailDto> listDtos = new ArrayList<LinkHomePageDetailDto>();
		
		for (LinkHomePageDetail entity : listEntities) {
			listDtos.add(mapperService.mapLinkHomePageDetailToDto(entity));
		}
		
		return listDtos;
	}
}