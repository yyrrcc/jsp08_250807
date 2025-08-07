<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!-- 패키지 memberDto 가져오기 -->
<%@ page import="jsp08_250807.servlet.MemberDto" %>
<!-- JSTL 가져오기 -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/stylemember.css" />
<title>가입한 회원 보기</title>
</head>
<body>
	
	<table>
		<tr>
			<th>No.</th>
			<th>회원 아이디</th>
			<th>회원 이름</th>
			<th>회원 나이</th>
			<th>회원 등록일</th>
		</tr>
			<c:forEach var="member" items="${memberLists }" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>${member.id }</td>
					<td>${member.name }</td>
					<td>${member.age }</td>
					<td>${member.regDate }</td>
				</tr>
			</c:forEach>			
	</table>
	<a href="welcome.do">메인 화면으로 이동하기</a>
</body>
</html>