<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm.jsp</title>
<style>
table, tr, td{border: 1px solid black; border-collapse: collapse;}
#button{border: 0px;}
</style>
</head>
<body>
<h2>LoginForm.jsp</h2>
<h3>action="memberLogin" method="post"</h3>
<h3>Servlet = controller패키지 > MemberLoginController</h3>
<form action="memberLogin" method="post" id="loginForm">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPw"></td>
		</tr>
	</table>
<input type="submit" value="로그인"> <input type="button" onclick="location.href='JoinForm.jsp'" value="회원가입">
</form>
</body>
<script>
function login(){
	loginForm.submit();
}
function joinForm(){
	location.href="JoinFrom.jsp";
}
</script>
</html>