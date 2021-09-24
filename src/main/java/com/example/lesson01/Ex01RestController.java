package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @ComponentScan(basePackages="com.*")
@RequestMapping("/lesson01/ex01")
@RestController	//@Controller + @ResponseBody => 항상 클래스 위쪽에! - 그 아래의 모든 메소드들은 responsebody가 모두 적용됨
public class Ex01RestController {
	
	//요청 URL : http://localhost/lesson01/ex01/3
	@RequestMapping("/3")
	public String printString() {
		return "@RestController를 사용해서 String을 리턴해본다.";	
	}
	
	@RequestMapping("/4")
	public Map<String, String> printMap() {
		Map<String, String> result = new HashMap<>();
		result.put("111", "111");
		result.put("111", "122");
		result.put("111", "133");
		return result;
	}
	
	@RequestMapping("/5")
	public Data printData() {
		Data data = new Data(); //일반 자바 bean
		data.setId(1);
		data.setName("이서영");
		return data;
		// Map, 일반 객체를 리턴하든 responsebody가 있다면 http converter를 타게 되고, jackson라이브러리가 json으로 표현해줌
	}
	
	@RequestMapping("/6")
	public ResponseEntity<Data> entity() {
		Data data = new Data(); //일반 자바 bean - 우리가 new 객체 하는거
		data.setId(100);
		data.setName("신바다");
		
		//return new ResponseEntity<>(data, HttpStatus.OK); //200 ok - 정상응답
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); //500에러
		
	}
}
