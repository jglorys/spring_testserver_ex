package com.example.lesson05;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson05Ex03Controller {
	
	//URL: http://localhost/lesson05/ex03
	@RequestMapping("/lesson05/ex03")
	public String ex03(Model model) {
		Date today = new Date(); //얘를 jsp로 내리려면 model이 있어야 함
		model.addAttribute("today", today);
		
		return "lesson05/ex03";
	}
}
