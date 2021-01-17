package com.learn.indexapi.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.indexapi.constant.UrlConst;
import com.learn.indexapi.dto.ApiResponse;
import com.learn.indexapi.dto.LinkHomePageDto;
import com.learn.indexapi.services.LinkHomePageService;

@CrossOrigin(origins = UrlConst.CROSSORIGIN, maxAge = 3600)
@RestController
public class LinkHomePageAdminController {
	
	@Autowired
	LinkHomePageService linkHomePageService;
	
	
	@GetMapping(UrlConst.LINK_HOME_PAGE)
	public ApiResponse<List<LinkHomePageDto>> getAll(){
		List<LinkHomePageDto> list = null;
		try {
			list = linkHomePageService.getAll();
		} catch (Exception e) {
			return new ApiResponse<List<LinkHomePageDto>>(list, HttpStatus.EXPECTATION_FAILED);
		}
		
		return new ApiResponse<List<LinkHomePageDto>>(list, HttpStatus.OK);
		
	}

}
