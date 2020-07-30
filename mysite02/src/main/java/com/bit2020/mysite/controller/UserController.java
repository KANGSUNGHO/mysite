package com.bit2020.mysite.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2020.mvc.util.MVCUtil;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("a");
		
			if("joinform".equals(action)) {
				MVCUtil.forward("user/joinform", request, response);
//				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/joinform.jsp");
//				rd.forward(request,response);
				
			}else if("joiform".equals(action)) {
				MVCUtil.redirect("/mysite02/user?a=joinsuccess",request, response);
//				response.sendRedirect(request.getContextPath());
			} 
			else if("joinsuccess".equals(action)) {
				MVCUtil.forward("user/joinsuccess", request, response);
//				response.sendRedirect(request.getContextPath());
			} 
			else {
				MVCUtil.redirect(request.getContextPath(),request, response);
//				response.sendRedirect(request.getContextPath());
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
