<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		
		<form method="post" action="/lesson04/ex01/add_user"> <!-- post방식으로 숨겨서 보내고, 주소저렇게해서 -->
			<b>이름:</b>
			<input type="text" name="name" class="form-control" placeholder="이름을 입력하세요."><br>
			<!-- name속성은 db컬럼명과 똑같게 맞춰주는게 편함 -->
			
			<b>생년월일:</b>
			<input type="text" name="yyyymmdd" class="form-control"><br>
			
			<b>이메일 주소:</b>
			<input type="text" name="email" class="form-control"><br>
			
			<b>자기소개:</b>
			<textarea rows="10" cols="30" name="introduce" class="form-control"></textarea><br>
			
			<input type="submit" class="btn btn-success" value="회원가입">
			<!-- 회원가입 버튼 누르면 form태그의 action주소로 request가 간다 -->
			
			
		</form>
	
	
	
	
	</div>

</body>
</html>