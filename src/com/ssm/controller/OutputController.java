package com.ssm.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.Input;
import com.ssm.pojo.Output;
import com.ssm.pojo.Products;
import com.ssm.service.OutputService;
import com.ssm.service.ProductsService;
@Controller
public class OutputController {
	
	@Autowired
	private OutputService outputService;
	@Autowired
	private ProductsService productsService;
	
	
	
	@RequestMapping("/outputProducts")
	public String outputProducts(Output output,Products products) {
		Date date=new Date();
		output.setOutputtime(date);
		outputService.insert(output);
		products.setName(output.getName());
		products.setCreatetime(date);
		products.setCount(products.getCount()-output.getPcount());
		productsService.updateProducts(products);
		return "forward:selectAll.do";
	}
	
	@RequestMapping("/searchOutput")
	public String SearchOutput(Model model) {
		List<Output> olist = outputService.selectAll();
		System.out.println(olist);
		model.addAttribute("olist", olist);
		return "searchOutput";
	}
	
	@RequestMapping("/searchOutputByKeyword.do")
	public <T> String SearchOutput(HttpServletRequest request, String name,String annt,
			@DateTimeFormat(pattern="yyyy-mm-dd")Date startDate,
			@DateTimeFormat(pattern="yyyy-mm-dd")Date enDate,Model model) 
	{
		System.out.println("123123123");
		Map map=new HashMap();
		map.put("name", name);
		map.put("annt",annt);
		map.put("startDate",request.getParameter("startDate"));
		map.put("enDate",request.getParameter("enDate"));
		System.out.println("321321223");
		System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"+map);
		List<Output> olist=outputService.selectByKeyword(map);
		System.out.println("olist--------------"+olist);
		model.addAttribute("olist", olist);
		return "searchOutput";
	}
	
	@RequestMapping("groupByOutputResult.do")
	public String groupByOutputResult(Model model) {
		int countTotal=0;
		List<Output> olist = outputService.selectByGroupName();
		for (Output output : olist) {
			countTotal+=output.getPcount();
		}
		model.addAttribute("countTotal", countTotal);
		model.addAttribute("olist", olist);
		return "groupByOutputResult";
	}
}
