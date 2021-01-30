package com.learn.indexapi.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.indexapi.constant.UrlConst;
import com.learn.indexapi.dto.ApiResponse;
import com.learn.indexapi.dto.HomeLinkDetailDto;
import com.learn.indexapi.services.HomeLinkDetailService;

@CrossOrigin(origins = UrlConst.CROSSORIGIN, maxAge = 3600)
@RestController
public class AdHomeLinkDetailController {
	
	@Autowired
	HomeLinkDetailService linkHomePageDetailService;

	@GetMapping(UrlConst.LINK_HOME_PAGE_DETAIL)
	public ApiResponse<List<HomeLinkDetailDto>> getAll(){
		List<HomeLinkDetailDto> list = null;
		try {
			list = linkHomePageDetailService.getAll();
		} catch (Exception e) {
			return new ApiResponse<List<HomeLinkDetailDto>>(list, HttpStatus.EXPECTATION_FAILED);
		}
		
		return new ApiResponse<List<HomeLinkDetailDto>>(list, HttpStatus.OK);
	}
}
