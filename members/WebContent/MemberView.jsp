<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberView.jsp</title>
<style>
table, tr, td{border: 1px solid black; border-collapse: collapse; padding: 5px; text-align: center;}
table{margin: auto;}
h2 {text-align: center;}
</style>
</head>
<body>
<h2>상세조회</h2>
<table>
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>생년월일</td>
		<td>성별</td>
		<td>이메일</td>
		<td>뒤로가기</td>
	</tr>
	<tr>
		<td>${member.userId}</td>
		<td>${member.userPw}</td>
		<td>${member.userName}</td>
		<td>${member.userBirth}</td>
		<td>${member.userGender}</td>
		<td>${member.userEmail}</td>
		<td><a href="memberList">뒤로가기</a></td>
	</tr>
</table>
</body>
</html>