<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
h1 {
	text-align: center;
}
fieldset {
	margin: 5px auto;
	width: 250px;
}
</style>
</head>
<body>
	<h1>로그인</h1>
	<form action="Login" method="get">
		<fieldset>
			<legend>로그인</legend>
			<label>ID: <input type="text" name="id"></label><br>
			<label>PW: <input type="password" name="pw"></label>
			<input type="submit" value="로그인" >
		</fieldset>
	</form>
</body>
</html>