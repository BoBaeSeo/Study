<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList.jsp</title>
<style>
table, tr, td{border: 1px solid black; border-collapse:collapse; padding: 5px;}
.cen{text-align: center; font-weight: bold;}
</style>
</head>
<body>
<h2>BoardList.jsp</h2>
<table>
	<tr>
		<td class="cen">글번호</td>
		<td class="cen">작성자</td>
		<td class="cen">글제목</td>
		<td class="cen">작성일자</td>
		<td class="cen">조회수</td>
	</tr>
	<c:forEach var="list" items="${boardList}">
		<tr>
			<td>${list.bNumber}</td>
			<td>${list.bWriter}</td>
			<td><a href="boardView?bNumber=${list.bNumber}">${list.bTitle}</a></td>
			<td>${list.bDate}</td>
			<td>${list.bHits}</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="5"><button onclick="bWrite()">글쓰기</button></td>
	</tr>
</table>
</body>
<script>
	function bWrite(){
		location.href="BoardWrite.jsp"
	}
</script>
</html>