package com.bit2020.mysite.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2020.mvc.util.MVCUtil;


public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
		// 1. 컨테이너에게 설정 파일(Bean 설정)의 path를 가져 오는 작업.
		String configPath = getServletConfig().getInitParameter("config");
		// 2. 컨테이너를 만든다. 		
		// ApplicationContext ac = new WebXmlApplicationContext();
		
		System.out.println("init() called-" + configPath);
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("service() called...");
		super.service(req, res);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() called...");
		
//		request.setCharacterEncoding("UTF-8");
		
		int visitCount = 0;
		
		// 쿠키 읽기
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if("visitCount".equals(cookieName)) {
					visitCount = Integer.parseInt(cookie.getValue());
				}
			}
		}
		
		// 쿠키 쓰기(굽기)
		visitCount++;
		Cookie cookie = new Cookie("visitCount",String.valueOf(visitCount));
		cookie.setMaxAge(24*60*60); // 1day , 24시 60분 60초까지 보관
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		
		MVCUtil.forward("main/index", request,response);
	}


	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() called...");
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() called...");
		super.destroy();
	}

}
