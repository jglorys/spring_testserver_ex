package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.NewUserDAO;
import com.example.lesson04.model.NewUser;

@Service
public class NewUserBO {
	
	@Autowired 
	private NewUserDAO newUserDAO;
	
	// select : 데이터 자체를 리턴  , 그 이외의 insert/update/delete : 성공 몇 행 했는지(int) || void
	public void addNewUser(String name, String yyyymmdd, String email, String introduce) { //따로따로 파라미터로 보내는 방식!
		newUserDAO.insertNewUser(name, yyyymmdd, email, introduce); //dao한테 인서트 해달라고 하고 리턴은 안함(void)
	}
	
	public NewUser getLastNewUser() { 
		return newUserDAO.selectLastNewUser();
	}
}
