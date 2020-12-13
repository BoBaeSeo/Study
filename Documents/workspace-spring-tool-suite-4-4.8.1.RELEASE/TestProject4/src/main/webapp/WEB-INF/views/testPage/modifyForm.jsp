<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, tr, td{
	border: 1px solid black;
	border-collapse: collapse;
	}
</style>
</head>
<body>
<h2>ModifyForm.jsp</h2>
<form action="modifyUser" method="post">
<table>
	<tr>
		<td>이름: </td><td><input type="text" name="userName" value=${dto.userName } readonly="readonly"></td>
	</tr>
	<tr>
		<td>전화번호: </td><td><input type="text" name="userPhone" value=${dto.userPhone }></td>
	</tr>
	<tr>
		<td>생년월일: </td><td><input type="date" name="userBirth" value=${dto.userBirth }></td>
	</tr>
</table>
	<input type="submit" value="수정">
</form>
</body>
</html>