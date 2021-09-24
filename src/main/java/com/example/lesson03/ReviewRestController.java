package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class ReviewRestController {
	@Autowired
	private ReviewBO reviewBO;
	
	// 요청 URL: http://localhost/lesson03/ex01
	// 요청 URL: http://localhost/lesson03/ex01?id=2
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			//@RequestParam(value="id") int id // 필수 파라미터 => 꼭보내야 에러나지 않음
			//@RequestParam(value="id", required=true) int id // 필수 파라미터
			@RequestParam("id") int id //필수 파라미터
			//@RequestParam(value="id", required=false) Integer id // int는 값이 꼭 채워져야할때, Integer은 null일수도 있을때. 비필수 파라미터
			//@RequestParam(value="id", defaultValue="1") int id // 비필수 파라미터, 디폴트값 1, required=false 넣어도됨
	) {
		
		System.out.println("### id :" + id);
		return reviewBO.getReviewById(id);
	}
	
	// 요청 URL : http://localhost/lesson03/ex02
	@RequestMapping("/lesson03/ex02") //INSERT
	public String ex02() { // String => view가 아닌, 그냥 잘 insert됐다는 문구출력
		Review review = new Review();
		review.setStoreId(7); //배달삼겹
		review.setMenu("삼겹혼밥세트");
		review.setUserName("이서영");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 적당합니다.");
		
		
		int rowCount = reviewBO.addReview(review); //BO insert
		return "성공한 행의 개수는 : " + rowCount;
	}
	
	
	// 요청 URL : http://localhost/lesson03/ex02/2
	@RequestMapping("/lesson03/ex02/2")
	public String ex02_2() { //넘겨야하는 애들을 parameter로 다 보내자!
		int rowCount = reviewBO.addReviewAsField(3, "치즈와퍼", "이서영", 5.0, "치즈 와퍼 좋아요!"); //by: where절에 들어가는 명확한 것 /  as:필드값으로 값들을 add할거다!
		
		return "성공한 행의 개수는 : " + rowCount;
	}
	
	// 요청 URL : http://localhost/lesson03/ex03?id=19&review=고기가 덜 익었지만 맛있어요
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam(value="id", required=true) int id,
			@RequestParam("review") String review
			) {
		
		int rowCount = reviewBO.updateReview(id, review);
		return "변경 완료 : " + rowCount;
	}
	
	// 요청 URL : http://localhost/lesson03/ex04?id=23
	@RequestMapping("/lesson03/ex04")
	public String ex04(
			@RequestParam(value="id", required=true) int id
			) {
		
		int rowCount = reviewBO.deleteReviewById(id);
		return "삭제 완료 : " + rowCount;
	}
	

	
}