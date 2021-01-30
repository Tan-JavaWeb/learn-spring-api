package com.learn.indexapi.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.indexapi.constant.UrlConst;
import com.learn.indexapi.dto.ApiResponse;
import com.learn.indexapi.dto.CheckResult;
import com.learn.indexapi.dto.HomeLinkDto;
import com.learn.indexapi.services.HomeLinkService;

@CrossOrigin(origins = UrlConst.CROSSORIGIN, maxAge = 3600)
@RestController
public class AdHomeLinkController {

	@Autowired
	HomeLinkService homeLinkService;

	/**
	 * Get all data from table home_links
	 * @return
	 */
	@GetMapping(UrlConst.HOME_LINK)
	public ApiResponse<List<HomeLinkDto>> getAll() {
		List<HomeLinkDto> list = null;
		try {
			list = homeLinkService.getAll();
		} catch (Exception e) {
			return new ApiResponse<List<HomeLinkDto>>(list, HttpStatus.EXPECTATION_FAILED);
		}

		return new ApiResponse<List<HomeLinkDto>>(list, HttpStatus.OK);
	}

	/**
	 * Get data from table home_links by id
	 * @param id
	 * @return
	 */
	@GetMapping(UrlConst.HOME_LINK_BY_ID)
	public ApiResponse<HomeLinkDto> getById(@PathVariable(required = false, name = "id") Long id) {
		HomeLinkDto homeLinkDto = null;
		try {
			homeLinkDto = homeLinkService.getHomeLinkById(id);
		} catch (Exception e) {
			return new ApiResponse<HomeLinkDto>(homeLinkDto, HttpStatus.EXPECTATION_FAILED);
		}

		return new ApiResponse<HomeLinkDto>(homeLinkDto, HttpStatus.OK);
	}

	/**
	 * Create 1 record table home_links
	 * @param homeLinkDto
	 * @return
	 */
	@PostMapping(UrlConst.HOME_LINK)
	public ApiResponse<Map<String, String>> create(@RequestBody HomeLinkDto homeLinkDto) {
		try {
			CheckResult checkResult = homeLinkService.checkCreate(homeLinkDto);
			if (!checkResult.isResult()) {
				return new ApiResponse<Map<String, String>>(checkResult.getMessgaes(), HttpStatus.OK);
			}
			homeLinkDto = homeLinkService.create(homeLinkDto);
			
			homeLinkDto.setSortOrder(homeLinkDto.getId());
			homeLinkService.update(homeLinkDto.getId(), homeLinkDto);
			return new ApiResponse<Map<String, String>>(new HashMap<>(), HttpStatus.OK);
		} catch (Exception e) {
			/// log.error(e.getMessage(), e);
			return new ApiResponse<Map<String, String>>(new HashMap<>(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 *  Update 1 record table home_links
	 * @param id
	 * @param homeLinkDto
	 * @return
	 */
	@PutMapping(UrlConst.HOME_LINK_UPDATE)
	public ApiResponse<Map<String, String>> update(@PathVariable(name = "id") final Long id,
			final @RequestBody HomeLinkDto homeLinkDto) {
		try {
			CheckResult checkResult = homeLinkService.checkUpdate(id, homeLinkDto);
			if (!checkResult.isResult()) {
				if(checkResult.getMessgaes().containsKey("id")) {
					return new ApiResponse<Map<String, String>>(new HashMap<>(), HttpStatus.NOT_FOUND);
				}
				
				return new ApiResponse<Map<String, String>>(checkResult.getMessgaes(), HttpStatus.OK);
			}
			
			homeLinkService.update(id, homeLinkDto);
			return new ApiResponse<Map<String, String>>(new HashMap<>(), HttpStatus.OK);
		} catch (Exception e) {
			return new ApiResponse<Map<String, String>>(new HashMap<>(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 *  Delete 1 record table home_links
	 * @param id
	 * @return
	 */
	@DeleteMapping(UrlConst.HOME_LINK_DELETE)
	public ApiResponse<List<HomeLinkDto>> deleteCategory(@PathVariable(name = "id") final Long id) {
		try {
			return ApiResponse.okStatus(homeLinkService.delete(id));
		} catch (IllegalArgumentException ex) {
			return new ApiResponse<List<HomeLinkDto>>(new ArrayList<HomeLinkDto>(), HttpStatus.EXPECTATION_FAILED);
		} catch (Exception ex) {
			return new ApiResponse<List<HomeLinkDto>>(new ArrayList<HomeLinkDto>(), HttpStatus.EXPECTATION_FAILED);
		}
	}
}