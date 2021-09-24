package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {

	
	//요청 URL : http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		
		//ResponseBody없이 오로지 Controller만 있어야 함!!
		//ViewResolcer 클래스 작동 -> 리턴된 String 이름의 view를 찾아서 view화면이 구성된다.
		return "lesson01/ex02";
		
		
	}
}
