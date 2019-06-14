package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.BigType;
import com.ssm.service.BigTypeService;
@Controller
public class BigTypeController {
	
	@Autowired
	private BigTypeService bigTypeService;
	
	
	
	@RequestMapping("/addBigType")
	public String addBigType() {
		return "addBigType";
	}
	
	@RequestMapping("/addBigType.do")
	public String addBigType(BigType bigType) {
		bigTypeService.insert(bigType);
		return "showPro";
	}
	
	
}
