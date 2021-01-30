package com.learn.indexapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.indexapi.dto.HomeLinkDetailDto;
import com.learn.indexapi.entities.HomeLinkDetailEntity;
import com.learn.indexapi.repositories.IHomeLinkDetailRepository;

@Service
public class HomeLinkDetailService {
	
	@Autowired
	private IHomeLinkDetailRepository detailRepository;
	
	@Autowired
	private MapperService mapperService;
	
	public List<HomeLinkDetailDto> getAll(){
		List<HomeLinkDetailEntity> listEntities = detailRepository.findAll();
		List<HomeLinkDetailDto> listDtos = new ArrayList<HomeLinkDetailDto>();
		
		for (HomeLinkDetailEntity entity : listEntities) {
			listDtos.add(mapperService.mapLinkHomePageDetailToDto(entity));
		}
		
		return listDtos;
	}
}