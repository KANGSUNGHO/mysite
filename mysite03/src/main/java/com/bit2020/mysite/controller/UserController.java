package com.bit2020.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.bit2020.mysite.service.UserService;
import com.bit2020.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo userVo) {
		userService.join(userVo);
		return "redirect:/user/joinsuccess";
	}
	

	@RequestMapping(value="/joinsuccess")
	public String joinsuccess() {
		return "user/joinsuccess";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String login(
//			HttpSession session,
//			Model model,
//			UserVo vo) {
//		
//		UserVo authUser = userService.getUser(vo);
//		if(authUser == null) {
//			model.addAttribute("result", "fail");
//			return "user/login";
//		}
//		
//		/* 인증 처리 */
//		session.setAttribute("authUser", authUser);
//		
//		return "redirect:/";
//	}
//	
//	@RequestMapping(value="/logout")
//	public String logout(HttpSession session) {
//		session.removeAttribute("authUser");
//		session.invalidate();
//	
//		return "redirect:/";
//	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		Long no = authUser.getNo();
		
		UserVo userVo = userService.getUser(no);
		model.addAttribute("userVo", userVo);
		
		return "user/update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(HttpSession session, UserVo vo) {
//		System.out.println(vo);
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		vo.setNo(authUser.getNo());
		userService.upadteUser(vo);
		
		return "redirect:/user/update";
	}
//	@ExceptionHandler(Exception.class)
//	public String handlerException() {
//		System.out.println("logging"); // 로깅
//		return "error/exception";  // 사과 페이지 
//		
//	}
	

}
