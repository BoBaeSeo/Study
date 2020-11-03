<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList.jsp</title>
</head>
<style>
table, tr, td{border: 1px solid black; border-collapse: collapse; padding: 5px; text-align: center;}
table{margin: auto;}
h2 {text-align: center;}
</style>
<body>
<h2>회원목록조회</h2>
<table>
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>생년월일</td>
		<td>성별</td>
		<td>이메일</td>
		<td>상세조회</td>
		<td>탈퇴</td>
		<td>메인으로</td>
	</tr>
	<c:forEach var="memList" items="${memberList}">
		<tr>
			<td>${memList.userId}</td>
			<td>${memList.userPw}</td>
			<td>${memList.userName}</td>
			<td>${memList.userBirth}</td>
			<td>${memList.userGender}</td>
			<td>${memList.userEmail}</td>
			<td><a href="memberView?userId=${memList.userId}">상세조회</a></td>
			<td><a href="memberDelete?userId=${memList.userId}">탈퇴</a></td>
			<td><a href="MemberMain.jsp">메인으로</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>