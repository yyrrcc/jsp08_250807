<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹사이트</title>
</head>
<body>
	<h3>Hello! World!</h3>
	<a href="HelloServlet">링크를 누르면 서블릿</a>
	<div>서블릿 클래스에서 애노테이션에 있는 주소로 이동하게 됨 @WebServlet("/HelloServlet") 이때 링크는 / 없이 주소만 입력 <br/>
		 보통은 doGet, method=post인 경우엔 doPost로
		 </div>
</body>
</html>