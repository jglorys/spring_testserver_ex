package com.example.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/lesson05")
@Controller
public class Lesson05Ex01Controller {

	
	//요청 URL: http://localhost/lesson05/ex01
	@RequestMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
}
