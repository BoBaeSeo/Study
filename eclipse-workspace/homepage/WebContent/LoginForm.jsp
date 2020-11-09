<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm.jsp</title>
</head>
<body>
<h2>LoginForm.jsp</h2>
<h3>action="memberLogin" method="post"</h3>
<h3>Servlet = controller 패키지 > MemberLoginController</h3>
<form action="memberLogin" method="post" name="LoginForm">
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
</form>
<button onclick="Login()">로그인</button> <button onclick="Join()">회원가입</button>
</body>
<script>
	function Login(){
		LoginForm.submit();
	}
	function Join(){
		location.href="JoinForm.jsp";
	}
</script>
</html>