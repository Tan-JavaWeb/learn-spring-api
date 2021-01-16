package com.learn.indexapi.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.indexapi.constant.UrlDefine;
import com.learn.indexapi.dto.ApiResponse;
import com.learn.indexapi.dto.DemoDto;
import com.learn.indexapi.services.DemoService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	@GetMapping(UrlDefine.DEMO)
	public ApiResponse<List<DemoDto>> getAll() {
		List<DemoDto> list = null;
		try {
			list = demoService.getAll();
		} catch (Exception e) {
			return new ApiResponse<List<DemoDto>>(list, HttpStatus.EXPECTATION_FAILED);
		}
		
		return new ApiResponse<List<DemoDto>>(list, HttpStatus.OK);
    }
}