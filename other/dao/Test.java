package com.ssm.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.entityTest.Admin;
import com.ssm.service.AdminService;
import com.ssm.service.BigtypeService;

public class Test {
	public static void main(String[] args) throws Throwable {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Admin admin2 = (Admin) context.getBean("admin");
		admin2.setName("11bvb221fghfghf1");
		admin2.setPwd("123");
		admin2.setState(1);
//		BigtypeService bs=(BigtypeService) context.getBean("bs");
		System.out.println(bs.getBigtypeById(19));
	}
}
