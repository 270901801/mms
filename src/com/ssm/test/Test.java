package com.ssm.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.pojo.Admin;
import com.ssm.service.AdminService;
import com.ssm.util.MD5Code;

public class Test {
	
	
	public static void main(String[] args) {
//		//spring相关配置文件
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
//		MD5Code md5 = new MD5Code();
//		
//		Admin admin = (Admin) context.getBean("admin");
//		admin.setName("zyj");
//		admin.setPwd("666");
//		admin.setState(0);
//		int i=1/0;
//		System.out.println(admin);
//		
//		IAdminService adminService = (IAdminService)context.getBean("adminService");
//		System.out.println(adminService);
//		adminService.insert(admin);
//		//adminService.delete();
		int i=1;//(Integer) null;
		String s = "sfs";
//		boolean b=i!=null&i!="";
		
//		if(i!="") {
			
			System.out.println(s==null);
			System.out.println(i==(Integer)null);
//		}
		
		
	}
	
	@org.junit.Test
	public void test() {
		System.out.println(1);
		int i=1;//(Integer) null;
		String s = "sfs";
//		boolean b=i!=null&i!="";
		
//		if(i!="") {
			
			System.out.println(s==null);
			System.out.println(i==(Integer)null);
	}
}
