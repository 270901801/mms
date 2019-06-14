package com.ssm.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.mapper.AdminMapper;
import com.ssm.pojo.Admin;
import com.ssm.service.AdminService;
import com.ssm.util.MD5Code;


@Controller("adminController")
public class AdminController{
	
	@Autowired
    private AdminService adminService;
	
	@RequestMapping("/index")
	public String index() {
		return "forward:selectAll.do";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("login.do")
	public String login(HttpServletRequest request,HttpSession session,Admin admin){
		admin.setPwd(new MD5Code().getMD5ofStr(admin.getPwd()));
		session.setAttribute("admin", admin);
		Admin admin2=adminService.selectByusernameAndPwd(admin);
		long currentTimeMillis = System.currentTimeMillis();
		admin=adminService.selectByusername(admin.getName());
		if(admin!=null) {
			if(admin.getState()==0) {
				if(currentTimeMillis-Long.parseLong(admin.getLasttime())>=24*60*60*1000) {
					admin.setWrongtimes(0);
					admin.setState(1);
					adminService.updateAdmin(admin);
				}else {
					request.setAttribute("loginError", "登录失败超过5次！您的账号被锁定，请24小时后登录");
					System.out.println("五次");
					return "login";
				}
			}
		}
		if(admin2!=null) {
			admin2.setLasttime(currentTimeMillis+"");
			System.out.println("登录成功");
			admin2.setWrongtimes(0);
			adminService.updateAdmin(admin2);
			System.out.println("设置输入错误次数为零"+admin2);
			session.setAttribute("admin", admin2);
			return "redirect:selectAll.do";
		}else {
			System.out.println("用户名密码错误");
//			admin=adminService.selectByusername(admin.getName());
			if(admin!=null) {
				String currentTimeMillis_str=""+currentTimeMillis;
				admin.setLasttime(currentTimeMillis_str);
				System.out.println(currentTimeMillis_str);
				System.out.println("有此用户名");
				if(currentTimeMillis-Long.parseLong(admin.getLasttime())>=24*60*60*1000) {
					admin.setWrongtimes(0);
				}else {
					admin.setWrongtimes(admin.getWrongtimes()+1);
					if(admin.getWrongtimes()>=5) {
						admin.setState(0);
					}
					adminService.updateAdmin(admin);
				}
				//剩余次数
				int leavetimes=5-admin.getWrongtimes();
				request.setAttribute("loginError", "登录失败，用户名或密码错误，您还有"+leavetimes+"机会");
				return "login";
			}else {
				System.out.println("无此用户名");
				request.setAttribute("loginError", "该用户不存在");
				return "login";
			}
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request,HttpSession session,Admin admin) {
		session.removeAttribute("admin");
		System.out.println("已注销");
		return "login";
	}
	
	@RequestMapping("/addAdmin")
	public String addAdmin(HttpSession session) {
		//验证是否是超级管理员
		Admin admin=(Admin) session.getAttribute("admin");
		if(admin.getRole()==0) {
			return "addAdmin";
		}else {
			return "forward:selectAll.do";
		}
		
	}
	
	@RequestMapping("/addAdmin.do")
	public String addAdmin(Admin admin) {
		adminService.insert(admin);
		return "redirect:showAdmin.do";
	}
	
	@RequestMapping("/showAdmin.do")
	public String showAdmin(Model model,HttpSession session) {
		//验证是否是超级管理员
		Admin admin=(Admin) session.getAttribute("admin");
		if(admin.getRole()!=0) {
			return "forward:selectAll.do";
		}
		List<Admin> adminList = adminService.selectAll();
		System.out.println(adminList);
		model.addAttribute("adminList", adminList);
		return "showAdmin";
	}
	@RequestMapping("/updateAdmin")
	public String updateAdmin(int id,Model model) {
		Admin admin = adminService.selectById(id);
		model.addAttribute("admin", admin);
		return "updateAdmin";
	}     
	@RequestMapping("/updateAdmin.do")
	public String updateAdmin(Admin admin) {
		System.out.println(admin);
		System.out.println("修改用户信息");
		admin.setPwd(new MD5Code().getMD5ofStr(admin.getPwd()));
		adminService.updateAdmin(admin);
		return "forward:showAdmin.do";
	}
	
	@RequestMapping("/deleteAdmin.do")
	public String deleteAdmin(int id) {
		adminService.deleteAdminById(id);
		return "forward:showAdmin.do";
	}
	
	
	
	
	
//	@RequestMapping("/login")
//    public ModelAndView login(Admin admin) throws Exception{
//        ModelAndView mv = new ModelAndView();
//        Admin a = adminService.selectByusernameAndPwd(admin);
////        List<Admin> list=adminService.
//        //根据用户名和密码查询user，如果存在，则跳转到 success.jsp 页面
//        if(a != null){
//            mv.addObject("name", a.getName());
//            mv.addObject("user", a);
//            mv.setViewName("/index.jsp");
//        }else{
//            //如果不存在，则跳转到 login.jsp页面重新登录
//            return new ModelAndView("redirect:/login.jsp");
//        }
//        return mv;
//    }
	
	
	
	
	
}
