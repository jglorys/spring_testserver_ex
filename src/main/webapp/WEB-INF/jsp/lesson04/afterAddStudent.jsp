<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가된 학생 정보</title>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<td>${student.id}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${student.name}</td>
		</tr>
		<tr>
			<th>폰번호</th>
			<td>${student.phoneNumber}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${student.email}</td>
		</tr>
		<tr>
			<th>장래희망</th>
			<td>${student.dreamJob}</td>
		</tr>
		<tr>
			<th>생성일</th>
			<td>${student.createdAt}</td>
		</tr>
	
	</table>
</body>
</html>