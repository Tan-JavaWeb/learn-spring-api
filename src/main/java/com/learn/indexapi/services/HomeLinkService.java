package com.learn.indexapi.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.indexapi.constant.MessagesConst;
import com.learn.indexapi.dto.CheckResult;
import com.learn.indexapi.dto.HomeLinkDto;
import com.learn.indexapi.entities.HomeLinkEntity;
import com.learn.indexapi.repositories.IHomeLinkRepository;
import com.learn.indexapi.utils.CustomMessages;

@Service
public class HomeLinkService {

	@Autowired
	private IHomeLinkRepository homePageRepository;

	@Autowired
	private MapperService mapperService;

	/**
	 * Get all data from table home_links
	 * @return
	 */
	public List<HomeLinkDto> getAll() {
		List<HomeLinkEntity> listEntities = homePageRepository.findByOrderBySortOrderAsc();
		List<HomeLinkDto> listDtos = new ArrayList<HomeLinkDto>();
		for (HomeLinkEntity entity : listEntities) {
			listDtos.add(mapperService.mapLinkHomePageToDto(entity));
		}

		return listDtos;
	}
	
	/**
	 * Get data from table home_links by id
	 * @param id
	 * @return
	 */
	public HomeLinkDto getHomeLinkById(long id) {
		HomeLinkEntity homeLinkEntity = homePageRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("homeLink id is not exist."));
		return mapperService.mapLinkHomePageToDto(homeLinkEntity);
	}
	
	/**
	 * Validate 1 record table home_links before create
	 * @param homeLinkDto
	 * @return
	 */
	public CheckResult checkCreate(HomeLinkDto homeLinkDto) {
		CheckResult checkResult = new CheckResult();
		Map<String, String> value = new HashMap<>();
		
		if (homeLinkDto == null || homeLinkDto.getName() == null || homeLinkDto.getName().trim().isEmpty()) {
			value.put("name", CustomMessages.ShowMessage(MessagesConst.MES_E1_002, new String[] { "Tên" }));
			checkResult.setMessgaes(value);
			return checkResult;
		}
		
		checkResult.setResult(true);
		return checkResult;
	}

	/**
	 * Create 1 record table home_links
	 * @param homeLinkDto
	 * @return
	 */
	@Transactional
	public HomeLinkDto create(HomeLinkDto homeLinkDto) {
		HomeLinkEntity homeLinkEntity = new HomeLinkEntity();
		homeLinkEntity.setName(homeLinkDto.getName());
		
		homeLinkEntity.setSortOrder(Long.valueOf(1));
		homePageRepository.save(homeLinkEntity);
		
		homeLinkDto.setId(homeLinkEntity.getId());
		homeLinkDto.setSortOrder(homeLinkEntity.getId());
		return homeLinkDto;
	}

	/**
	 *  Validate 1 record table home_links before update
	 * @param id
	 * @param homeLinkDto
	 * @return
	 */
	public CheckResult checkUpdate(long id, HomeLinkDto homeLinkDto) {
		CheckResult checkResult = new CheckResult();
		Map<String, String> value = new HashMap<>();
		if (!homePageRepository.existsById(id)) {
			value.put("id", "");
			checkResult.setMessgaes(value);
			return checkResult;
		}
		
		if (homeLinkDto == null || homeLinkDto.getName() == null || homeLinkDto.getName().trim().isEmpty()) {
			value.put("name", CustomMessages.ShowMessage(MessagesConst.MES_E1_002, new String[] { "Tên" }));
			checkResult.setMessgaes(value);
			return checkResult;
		}
		
		checkResult.setResult(true);
		return checkResult;
	}
	
	/**
	 *  Update 1 record table home_links
	 * @param id
	 * @param homeLinkDto
	 */
	@Transactional
	public void update(long id, HomeLinkDto homeLinkDto) {
		HomeLinkEntity homeLinkEntity = homePageRepository.findById(id).get();
		homeLinkEntity.setName(homeLinkDto.getName());
		homeLinkEntity.setSortOrder(homeLinkDto.getSortOrder());
		homePageRepository.save(homeLinkEntity);
	}

	/**
	 *  Create 1 record table home_links
	 * @param id
	 * @return
	 */
	@Transactional
	public List<HomeLinkDto> delete(long id) {
		HomeLinkEntity homeLinkEntity = homePageRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("homeLink id is not exist."));
		homePageRepository.delete(homeLinkEntity);
		return getAll();
	}
}