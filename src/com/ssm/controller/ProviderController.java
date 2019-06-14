package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.Provider;
import com.ssm.pojo.SmallType;
import com.ssm.service.ProviderService;
import com.ssm.service.SmallTypeService;

@Controller
public class ProviderController {
	
	@Autowired
	private ProviderService providerService;
	
	@RequestMapping("/addProvider")
	public String addProvider() {
		return "addGys";
	}
	
	@RequestMapping("/addProvider.do")
	public String addProvider(Provider provider) {
		providerService.insert(provider);
		return "redirect:selectAll.do";
	}
}
