<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main.jsp</title>
</head>
<body>
<h2>Main.jsp</h2>
<button onclick="JoinForm()">회원가입(JoinForm.jsp)</button>
<button onclick="LoginForm()">로그인(LoginForm.jsp)</button>
</body>
<script>
	function JoinForm(){
		location.href="JoinForm.jsp"
	}
	
	function LoginForm(){
		location.href="LoginForm.jsp"
	}
</script>
</html>