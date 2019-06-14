package com.ssm.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.BigType;
import com.ssm.pojo.Products;
import com.ssm.pojo.Provider;
import com.ssm.pojo.SmallType;
import com.ssm.service.ProductsService;
import com.ssm.service.ProviderService;
import com.ssm.util.ExportExcel;
import com.ssm.util.PageUtils;


@Controller
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	private PageUtils pageUtils=new PageUtils();
	@Autowired
	private ProviderService providerService;
	
	
	@RequestMapping("/selectAll.do")
	public String selectAll(Model model,Integer cp,HttpSession session) {
		System.out.println("cp:"+cp);
		if(cp==null) {
			pageUtils.setCurrentPage(1);
		}else {
			pageUtils.setCurrentPage(cp);
		}
		//给分页组件设置内容
		pageUtils.setPageSize(20);
		pageUtils.setTotal(productsService.selectCount());
		//设置zongyes
		int pageTotal=pageUtils.getTotal()%pageUtils.getPageSize()==0?pageUtils.getTotal()/pageUtils.getPageSize():
			(pageUtils.getTotal()/pageUtils.getPageSize()+1);
		pageUtils.setPageTotal(pageTotal);
		List<Products> list = productsService.selectAll(
				new RowBounds((pageUtils.getCurrentPage()-1)*pageUtils.getPageSize(),
						pageUtils.getPageSize()));
		List<BigType> bigList=productsService.selectBigType();
		List<BigType> smallList=productsService.selectSmallType();
		System.out.println("bigType--------------"+bigList);
		System.out.println("smallType--------------"+smallList);
		session.setAttribute("bigList", bigList);
		session.setAttribute("smallList", smallList);
		System.out.println(pageUtils);
		if(list==null) {
			model.addAttribute("msg","数据加载不到请重试");
		}else {
			model.addAttribute("p", pageUtils);
			model.addAttribute("pList",list);
			model.addAttribute("URL","selectAll.do");
		}
		return "index";
	}
	
	@RequestMapping("/selectByName.do")
	public <T> String findProByNameAndType(String keyword,Integer sid,Model model) {
		Map<String, T> map=new HashMap<>();
		map.put("keyword", (T) keyword);
		map.put("sid",(T) sid);
		System.out.println("ssssssssssssssssss"+map);
		List<Products> products=productsService.selectByNameAndType(map);
		model.addAttribute("pList",products);
		return "searchResult";
	}
	
	@RequestMapping("/inputPro.do")
	public String inputPro(String keyword,Model model) {
		List<Products> products=productsService.selectByName(keyword);
		model.addAttribute("pList",products);
		return "searchResult";
	}	
	
	@RequestMapping("/FindProByIdServlet")
	public String findProById(int id,int flag,Model model) {
		Products product=productsService.selectById(id);
		model.addAttribute("p",product);
		if(flag==1) {
			List<Provider> proList=providerService.selectAll();
			model.addAttribute("proList", proList);
			return "input";
		}else if(flag==2){
			return "output";
		}else if(flag==3) {
			return "showPro";
		}else {
			return "forward:selectAll.do";
		}
	}
	
	@RequestMapping("/newProduct")
	public String newProduct() {
		return "newInput";
	}
	@RequestMapping("/newProduct.do")
	public String newProduct(Products products) {
		System.out.println(products);
		productsService.insertProduct(products);
		return "forward:selectAll.do";
	}
	
	
	@RequestMapping("/updateProducts")
	public String updateProducts() {
		return "showPro";
	}
	
	@RequestMapping("/updateProducts.do")
	public String updateProducts(Products products) {
		productsService.updateProducts(products);
		return "forward:selectAll.do";
	}
	
	@RequestMapping("/outputData.do")
	public void outputData(HttpServletResponse response) {
		List<Products> proList=productsService.selectAll();
		ExportExcel<Products> ee=new ExportExcel<Products>();
		String[] Pheaders = {"id","name","bid","sid","units","count","wvalue","state","createtime"};
		String PfileName="productExcel";
		ee.exportExcel(Pheaders, proList, PfileName, response);

	}
	
	
}
