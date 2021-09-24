package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") //메소드에 붙은 Mapping보다 먼저 적용됨
@Controller //처음에 요청을 받아내는 클래스! 여기서 부터 읽음
public class Ex01Controller {
	
	// String 출력하기
	@ResponseBody //얘는 순서 상관없이 어느곳이든 ㄱㅊ -> 메소드 당 한개만 있으면 됨. 내가 리턴하는 값이 ResponseBody에 박혀서 출력됨
					//return되는 값을 HTML Response Body로 보낸다.
	// 요청 URL : http://localhost/lesson01/ex01/1
	@RequestMapping("/1") //주소를 매핑해줌
	public String printString() {
		String text = "예제 1번<br>문자열을 response body로 보내는 예제";
		return text; //이 데이터가 ResponseBody에 담겨서 내려감
	
	}
	
	// 요청 URL : http://localhost/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> printMap() {
		// {"키"  = 값}
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("바나나", 43333);
		map.put("파인애플", 43434);
		map.put("포도", 42222);
		
		
		// MessageConverter 가 내부적으로 동작하게 됨
		// map을 리턴하면 json으로 나타난다. => web starter(build.gradle안에)에 jackson이라는 라이브러리가 포함되어 있기 때문
		// @ResponseBody 어노테이션이 있기 때문에 jackson이 동작함
		return map;
		
	}
 }
