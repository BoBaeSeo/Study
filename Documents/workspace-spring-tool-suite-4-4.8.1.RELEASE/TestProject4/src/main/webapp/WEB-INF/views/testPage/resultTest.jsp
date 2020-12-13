<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resultTest.jsp</title>
<style>
	table, tr, td{
	border: 1px solid black;
	border-collapse: collapse;
	}
	td{
	padding: 10px;
	}
</style>
</head>
<body>
	<h2>resultTest.jsp</h2>
	<table>
		<tr>
			<td>이름 </td> 
			<td>전화번호 </td> 
			<td>생년월일: </td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<c:forEach var="list" items="${userList }">
			<tr>
				<td> ${list.userName }</td>
				<td> ${list.userPhone }</td>
				<td> ${list.userBirth }</td> 
				<td><button onclick="location.href='modifyTest?userName=${list.userName}'">수정</button></td>
				<td><button onclick="location.href='deleteTest?userName=${list.userName}'">삭제</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>