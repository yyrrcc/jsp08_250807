<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h4>로그인을 하세요</h4>
	<!-- 기본 Servlet으로 하는 경우에는 action에 알맞은 .jsp 넣고 -->
	<!-- *.do 사용하기 위해서는 .do 넣으면 된다 -->
	<!-- FrontController 최종본으로 확인할 것 -->
	<form action="loginOk.do" name="loginCheck" method="post">
		아이디 <input type="text" name="id"><br/>
		비밀번호 <input type="password" name="pw"><br/>
		<input type="submit" value="로그인">
		<input type="reset" value="다시 입력하기">
	</form>
	
	<!-- 로그인 실패 시 출력 될 문구 -->
	<!-- ${errorMsg != null } -->
	<!-- session에 가져온 값에 따라 달라질 수 있음 -->
	<!-- 로그아웃 될 때도 메세지 뜸 -->
	<c:if test="${not empty msg}">
		<hr>
		<h3 style="color: red">${msg }</h3>
	</c:if>

</body>
</html>