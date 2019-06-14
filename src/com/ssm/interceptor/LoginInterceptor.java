package com.ssm.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.pojo.Admin;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

		// 1.定义哪些路径是不需要拦截(将这些路径称为白名单)
		Set<String> uri = new HashSet<String>();
//		uri.add("/logout.do");
		uri.add("/login.do");
		uri.add("/login");
		// 获取请求路径.
		String servletPath = request.getServletPath();
		System.out.println(123);
		if (uri.contains(servletPath)) {
			return true;
		}

		// 2.判断用户是否登录,如果登录就放行
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");// Const.LOGIN_USER
		if (admin != null) {
			System.out.println("未拦截");
			return true;
		} else {
			System.out.println("拦截");
			System.out.println(request.getContextPath());
			 response.sendRedirect(request.getContextPath()+"/login"); 
//			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return false;
		}
	}
}
