package com.bit2020.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("")
	public String index() {
		return "main/index"; // 원래는 "/WEB-INF/views/main/index.jsp" 이걸로 return해야 하는데 view resolve에서 prefix, suffix로 앞뒤를 설정해놨기 때문. 
	}

}
