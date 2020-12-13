<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertForm</title>
<style>
	table, tr, td{
	border: 1px solid black;
	border-collapse: collapse;
	}
</style>
</head>
<body>
<h2>insertForm</h2>
<form action="insertTest" method="post">
<table>
	<tr>
		<td>이름: </td><td><input type="text" name="userName"></td>
	</tr>
	<tr>
		<td>전화번호: </td><td><input type="text" name="userPhone" placeholder="010-0000-0000"></td>
	</tr>
	<tr>
		<td>생년월일: </td><td><input type="date" name="userBirth"></td>
	</tr>
</table>
	<input type="submit" value="전송">
</form>
</body>
</html>