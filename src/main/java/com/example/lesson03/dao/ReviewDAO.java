package com.example.lesson03.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;


@Repository
public interface ReviewDAO {
	public Review selectReviewById(int id); //구현할거없어서 세미클론으로 그냥 닫아주면됨. id는 필수값이므로 null안됨-> Integer말고 int로!
	// public Review selectReviewById(@Param("id") int id); 이렇게 하면 맵이 됐다고 생각하자.. id라는 키의 id라는 값이 있는 맵 => 파라미터타입map가능 
	
	public int insertReview(Review review); //리뷰의 내용을 xml쪽으로 넘겨버림 - 하나넘겨서 @Param안붙임

	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") double point, 
			@Param("review") String review); //map을 구성
	
	
	public int updateReview(
			@Param("id") int id,
			@Param("review") String review);
	
	public int deleteReviewById(int id);

}