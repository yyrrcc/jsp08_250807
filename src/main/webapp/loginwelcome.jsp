<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<%-- 1. 자바 세션으로 아이디 값 가져오기
	<%
		String sid = (String) session.getAttribute("sid");
	%>
	--%>
	<!-- <h4> <%-- <%= sid %> --%>님 환영합니다!</h4>  -->
	
	<!-- 2. 세션스코프로 가져오기 -->
	<%
		if (session.getAttribute("sid") == null) {
			response.sendRedirect("login.do");
		}
	%>
	<!-- <h4>${sessionScope.sid }님 안녕하세요, 환영합니다!</h4> -->
	<h4>${elid }님 환영합니다!</h4>
	<a href="member.do">가입한 회원 보기</a>
	<br>
	<a href="board.do">게시판 바로가기</a>
	<br>
	<a href="logout.do"><input type="button" value="로그아웃"></a>
</body>
</html>