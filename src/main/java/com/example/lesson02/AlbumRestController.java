package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.AlbumBO;
import com.example.lesson02.model.Album;

@RestController
public class AlbumRestController {
	
	
	@Autowired
	private AlbumBO albumBO; //Spring창고에 있는 BO객체를 가지고 옴 = dependency injection (의존성 주입)
	
	//얘는 BO(Service역할)한테 요청함
	@RequestMapping("/lesson02/ex01")
	public List<Album> ex01() {
		List<Album> albumList = albumBO.getAlbumList(); //BO,DAO는 Spring bean이므로 new해서 하지않음 => @Autowired
		return albumList; //ResponseBody에 담아서 json으로 내려감
	}
	
}
