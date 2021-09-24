package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.NewStudentBO;
import com.example.lesson04.model.NewStudent;

@RequestMapping("/lesson04")
@Controller
public class NewStudentController {
	
	@Autowired
	private NewStudentBO newStudentBO;
	
	// 요청 URL : http://localhost/lesson04/ex02/1
	@GetMapping("/ex02/1")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// 요청 URL : http://localhost/lesson04/ex02/add_student
	@PostMapping("/ex02/add_student")
	public String addStudent(
			@ModelAttribute NewStudent newStudent,
			Model model
			// name 태그 값과 일치하는 필드에 값이 들어간다.
			) {
		//학생 정보 파라미터 받기
		
		//DB insert
		newStudentBO.addNewStudent(newStudent);
		
		//DB select --> [useGeneratedKeys="true" keyProperty="id"]해서 가능!
		NewStudent newStudentModel = newStudentBO.getNewStudentById(newStudent.getId()); //model에 넣으려고, response를 위한 NewStudent객체! view를 꾸미기위한
		
		//VIEW 데이터 세팅 -> model에 
		model.addAttribute("student", newStudentModel);
		
		return "lesson04/afterAddStudent";
	}
}
