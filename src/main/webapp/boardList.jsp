<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 패키지 가져오기 -->
<%@page import="jsp08_250807.servlet.BoardDto" %>
<!-- JSTL 가져오기 -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/styleboard.css" />
<title>게시판</title>
</head>
<body>
	<h2>자유 게시판 목록</h2>
	<table>
		<tr>
			<th>No.</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
		</tr>
		
		<!-- items에는 배열, 리스트 같은 것들이 들어온다 -->
		<c:forEach var="boardDto" items="${boardLists }" varStatus="status">
			<tr>
				<td>${status.index + 1 }</td>
				<td>
				<!--  글제목 길이가 너무 길 때 앞부분만 추출하는 것 -->
					<c:choose>
						<c:when test="${fn:length(boardDto.title) > 20}">
							<a href="#">${fn:substring(boardDto.title, 0, 20) }...</a>
						</c:when>
						<c:otherwise>
							${boardDto.title }
						</c:otherwise>
					</c:choose>
				</td>
				<td>${boardDto.writer }</td>
				<td>${boardDto.date }</td>
			</tr>
		</c:forEach>
		
	</table>
	<a href="welcome.do">메인 화면으로 이동하기</a>
</body>
</html>