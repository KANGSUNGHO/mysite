package com.bit2020.mysite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2020.mvc.util.MVCUtil;
import com.bit2020.mysite.repository.GuestbookRespository;
import com.bit2020.mysite.vo.GuestbookVo;


public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("a");
		if("insert".equals(action)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");
			
			GuestbookVo vo = new GuestbookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(content);
			new GuestbookRespository().insert(vo);
			MVCUtil.redirect(request.getContextPath() + "/guestbook",request,response);
		} else if("deleteform".equals(action)) {
			MVCUtil.forward("guestbook/deleteform",request,response);
		} else if("delete".equals(action)) {
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			System.out.println(no + ":" + password);
			
			new GuestbookRespository().delete(Long.parseLong(no), password);
			MVCUtil.redirect(request.getContextPath()+"/guestbook",request,response);
		} else {
			List<GuestbookVo> list = new GuestbookRespository().findAll();
			request.setAttribute("list",list);
			MVCUtil.forward("guestbook/list",request,response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
