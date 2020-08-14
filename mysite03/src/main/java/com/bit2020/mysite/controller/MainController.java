package com.bit2020.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2020.mysite.vo.GuestbookVo;

@Controller
public class MainController {
	
	@RequestMapping("")
	public String index() {
		return "main/index"; // 원래는 "/WEB-INF/views/main/index.jsp" 이걸로 return해야 하는데 view resolve에서 prefix, suffix로 앞뒤를 설정해놨기 때문. 
	}
	
	@ResponseBody //@ResponseBody를 붙이지 않으면 이것을 ViewResolver가 받는데 @ResponsesBody를 붙이면 메시지 컨버터가 받아서 HTML로 응답. 
	@RequestMapping("/hello")
	public String hello() {
		return "안녕하세요~";
	}

	@ResponseBody
	@RequestMapping("/json")
	public Object json() {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(10L);
		vo.setName("강성호");
		vo.setMessage("안녕하세요~");

		return vo;
	}
}
