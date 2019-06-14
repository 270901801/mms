package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.pojo.Admin;
import com.ssm.service.IAdminService;
@Controller("adminController")
public class AdminController{
	@Autowired
    public IAdminService adminService;
	@RequestMapping("/login")
    public ModelAndView login(Admin admin) throws Exception{
        ModelAndView mv = new ModelAndView();
        Admin a = adminService.selectByusernameAndPwd(admin);
        //根据用户名和密码查询user，如果存在，则跳转到 success.jsp 页面
        if(a != null){
            mv.addObject("username", a.getName());
            mv.addObject("user", a);
            mv.setViewName("/index.jsp");
        }else{
            //如果不存在，则跳转到 login.jsp页面重新登录
            return new ModelAndView("redirect:/login.jsp");
        }
        return mv;
    }
}
