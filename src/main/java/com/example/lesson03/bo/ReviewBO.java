package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReviewById(int id)  { //만약에 username과 point로 가지고 온다면, ByUsernameAndId로 함ㅎㅎ
		return reviewDAO.selectReviewById(id);
	}
	
	public int addReview(Review review) {//성공한 행의 횟수를 리턴.. mybatis가 그냥해줌
		return reviewDAO.insertReview(review); //리뷰객체 통으로 넘김 => 몇 행이 insert됐는지,, 성공한 행의 갯수출력됨
	}
	
	public int addReviewAsField(int storeId, String menu, String userName, double point, String review) {
		//3, "치즈와퍼", "이서영", 5.0, "치즈 와퍼 좋아요!"
		return reviewDAO.insertReviewAsField(storeId, menu, userName,  point,  review);
	}
	
	public int updateReview(int id, String review) {
		return reviewDAO.updateReview(id, review);
	}
	
	public int deleteReviewById(int id) {
		return reviewDAO.deleteReviewById(id);
	}
	
}
