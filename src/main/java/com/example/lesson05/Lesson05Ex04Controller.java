package com.example.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson05Ex04Controller {

	@RequestMapping("/lesson05/ex04")
	public String ex04() {
		return "lesson05/ex04";
	}
}
