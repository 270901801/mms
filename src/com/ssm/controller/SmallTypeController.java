package com.ssm.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ssm.pojo.SmallType;
import com.ssm.service.ProductsService;
import com.ssm.service.SmallTypeService;

@Controller
public class SmallTypeController {
	
	@Autowired
	private SmallTypeService smallTypeService;
	@Autowired
	private ProductsService productsService;
	
	@RequestMapping("/addSmallType")
	public String addsmallType() {
		return "addSmallType";
	}
	
	@RequestMapping("/addSmallType.do")
	public String addsmallType(SmallType smallType) {
		smallType.setState(1);
		System.out.println(smallType);
		smallTypeService.insert(smallType);
		return "newInput";
	}
	
	@RequestMapping("/selectSmallByBid.do")
	public void selectSmallByBid(Integer bid ,HttpServletResponse response ) throws IOException {
		JSONArray jsonArray=new JSONArray();
		System.out.println(productsService.selectSmallTypeByBigType(bid));
		List<SmallType> smallList = productsService.selectSmallTypeByBigType(bid);
		System.out.println(smallList);
		for(SmallType smallType:smallList) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("sid", smallType.getId());
			jsonObject.put("sname", smallType.getName());
			jsonArray.add(jsonObject);
		}
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(jsonArray.toString());
	}
}
