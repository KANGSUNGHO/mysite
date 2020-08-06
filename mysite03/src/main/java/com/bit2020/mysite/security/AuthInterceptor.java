package com.bit2020.mysite.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("1");
		// 1. Handler 종류 확인
		if(handler instanceof HandlerMethod == false) {
			// DefaultServletHandler가 처리하는 경우(보통, assets의 정적 자원 접근)
			return true;
		}
		
		System.out.println("2");
		// 2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		System.out.println("3");
		// 3. Handler Method의 @Auth 받아오기 
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		System.out.println("4");
		// 4. @Auth가 안붙어 있는 경우 
		if(auth == null) {
			return true;
		}
		
		System.out.println("5");
		// 5. @Auth가 붙어 있기 때문에 인증(Authentification) 여부 확인
		HttpSession session = request.getSession();
		if(session == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		Object authUser = session.getAttribute("authUser");
		if(authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		System.out.println("6");
		// 6. @Auth가 붙어 있고 인증도 되어 있음. 
		return true;
	}

}
