package com.learn.indexapi.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.indexapi.dto.HomeLinkDetailDto;
import com.learn.indexapi.dto.HomeLinkDto;
import com.learn.indexapi.entities.HomeLinkDetailEntity;
import com.learn.indexapi.entities.HomeLinkEntity;

@Service
public class MapperService {
	
	@Autowired
	private ModelMapper mapper;

	public HomeLinkDto mapLinkHomePageToDto(HomeLinkEntity linkHomePage) {
		return mapper.map(linkHomePage, HomeLinkDto.class);
	}
	
	public HomeLinkDetailDto mapLinkHomePageDetailToDto(HomeLinkDetailEntity linkHomePageDetail) {
		return mapper.map(linkHomePageDetail, HomeLinkDetailDto.class);
	}
}