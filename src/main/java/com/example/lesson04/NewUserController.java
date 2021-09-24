package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.NewUserBO;
import com.example.lesson04.model.NewUser;

@RequestMapping("/lesson04")
@Controller
public class NewUserController {
	
	@Autowired
	private NewUserBO newUserBO;
	
	
	//요청 URL : http://localhost/lesson04/ex01/1
	@RequestMapping(method = RequestMethod.GET, path = "/ex01/1") //jsp의 경로를 return 하므로, String으로
	public String ex01_1() {
		return "lesson04/addUser"; ///WEB-INF/jsp/lesson04/addUser.jsp
	} // RestController아닌 그냥 Controller이므로 리턴되는 String의 view주소를 찾아 들어가게 됨
	
	
	//요청 URL : http://localhost/lesson04/ex01/add_user --> 얘는 직접 쳐서 못들어감 (POST)
	// @RequestMapping(path = "/ex01/add_user", method = RequestMethod.POST) //새로운 뷰쪽으로 넘기자!!
	@PostMapping("/ex01/add_user") //위에 있는거랑 동일함
	public String addUser(
				@RequestParam("name") String name,
				@RequestParam("yyyymmdd") String yyyymmdd,
				@RequestParam("email") String email,
				@RequestParam(value = "introduce", required = false) String introduce /*비필수 parameter*/
			) {
		
		//DB Insert
		newUserBO.addNewUser(name, yyyymmdd, email, introduce);
		
		
		return "lesson04/afterAddUser"; //새로운 view리턴 .. 프리픽스, 서픽스
	}
	
	// 요청 URL _ get으로 설정해야됨 : http://localhost/lesson04/ex01/last_user
	@GetMapping("/ex01/last_user")
	public String getLastUser(Model model) {  
		//@Controller만 있고, @ResponseBody없으므로 String은 view이름이다.
		// 마지막에 가입된 사람 하나의 정보를 가지고 온다. select DB
		NewUser user = newUserBO.getLastNewUser();
		
		model.addAttribute("user", user); //"user"라는 키로 jsp 데이터를 꺼내서 사용할 수 있게 됨. NewUseruser 의 user객체임
		model.addAttribute("title", "회원 정보"); //나중에 jsp에서 "title"라는 키로 get하려고 하면, "회원 정보"값을 얻어 낼 수 있음
		
		return "lesson04/lastUser"; //결과 jsp (프리픽스, 서픽스 제외..)
	}
	
}
