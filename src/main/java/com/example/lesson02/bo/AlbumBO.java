package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.AlbumDAO;
import com.example.lesson02.model.Album;

@Service
public class AlbumBO {
	
	@Autowired
	private AlbumDAO albumDAO;
	
	//Spring MVC 패턴에서 Business Layer=Service(로직 담당) 하는애 - db에서 바로 가져올 수 없음
	// 애는 db에 직접 접근할 수 있는 dao(Repository)한테 요청함
	public List<Album> getAlbumList() {
		
		List<Album> albumList = albumDAO.selectAlbumList(); //DAO가 챙겨서 리턴해줌
		return albumList;
		// 그냥 바로 return = albumDAO.selectAlbumList(); 해도 됨
	}
}
