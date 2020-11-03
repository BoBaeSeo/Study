<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main.jsp</title>
</head>
<body>
<h1>Main.jsp</h1>
<button onclick=Join()>회원가입(JoinForm.jsp)</button> 
<button onclick=Login()>로그인(LoginForm.jsp)</button>
</body>
<script>
function Join(){
	location.href="JoinForm.jsp";
}
function Login(){
	location.href="LoginForm.jsp";
}
</script>
</html>