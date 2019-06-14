package com.ssm.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class SSMAscpect {
	
	@Pointcut("execution (* com.hzit.ssm.service.AdminService.*(..))")
	public void pointcut() {
	}
	@Before("pointcut()")
	public void before() {
		System.out.println("ȫ�߼�顣����");
	}
	@After("pointcut()")
	public void after() {
		System.out.println("��־��¼������");
	}
}
