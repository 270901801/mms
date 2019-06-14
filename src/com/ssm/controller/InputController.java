package com.ssm.controller;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.Admin;
import com.ssm.pojo.Input;
import com.ssm.pojo.Products;
import com.ssm.pojo.Provider;
import com.ssm.service.InputService;
import com.ssm.service.ProductsService;
import com.ssm.service.ProviderService;

@Controller
public class InputController {
	
	@Autowired
	private InputService inputService;
	@Autowired
	private ProductsService productsService;
	@Autowired
	private ProviderService providerService;
	
	@RequestMapping("/inputProducts")
	public String inputProducts(Input input,Products products,Model model) {
		Date date=new Date();
		input.setInputtime(date);
		//插入库存记录
		System.out.println(input);
		inputService.insert(input);
		//更新products表
		products.setCreatetime(date);
		products.setName(input.getName());
		if (input.getPcount()>0) {
			products.setCount(products.getCount()+input.getPcount());
			productsService.updateProducts(products);
			//将数据返回页面
			List<Input> ilist = inputService.selectAll();
			System.out.println(ilist);
			model.addAttribute("ilist", ilist);
			return "forward:searchInput";
		}else {
			String message="入库失败";
			model.addAttribute("input_error", message);
			return "selectAll.do";
		}
	}
	
	@RequestMapping("/searchInput")
	public String SearchInput(Model model) {
		List<Input> ilist = inputService.selectAll();
		List<Provider> proList=providerService.selectAll();
		System.out.println("searchInput"+ilist+"/n"+proList);
		model.addAttribute("proList", proList);
		model.addAttribute("ilist", ilist);
		return "searchInput";
	}
	
	@RequestMapping("/searchInputByKeyword.do")
	public <T> String SearchInput(HttpServletRequest request,
			String name,String annt,String pname,
			@DateTimeFormat(pattern="yyyy-mm-dd")Date startDate,
			@DateTimeFormat(pattern="yyyy-mm-dd")Date enDate,Model model) 
	{
		Map map=new HashMap();
		map.put("name", name);
		map.put("pname", pname);
		map.put("annt", annt);
		map.put("startDate",request.getParameter("startDate"));
		map.put("enDate",request.getParameter("enDate"));
//		System.out.println("ttttttttttttttt"+map);
		List<Input> ilist = inputService.selectByKeyword(map);
//		System.out.println(ilist);
		List<Provider> proList=providerService.selectAll();
		model.addAttribute("proList", proList);
		model.addAttribute("ilist", ilist);
		return "searchInput";
	}
	
	
	@RequestMapping("groupByInputResult.do")
	public String  selectByGroupName(Model model) {
		List<Input> ilist = inputService.selectByGroupName();
		int countTotal=0;
		BigDecimal priceTotal = new BigDecimal(0);
		for (Input input : ilist) {
			countTotal+=input.getPcount();
			priceTotal=priceTotal.add(input.getPrice());
			System.out.println(input.getPrice());
			System.out.println(priceTotal);
			System.out.println("------------------------------------------------------------------------");
		}
		model.addAttribute("countTotal", countTotal);
		model.addAttribute("priceTotal", priceTotal);
		model.addAttribute("ilist", ilist);
		return "groupByInputResult";
	}
}
