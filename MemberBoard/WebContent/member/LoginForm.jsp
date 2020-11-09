<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm.jsp</title>
	<style>
		fieldset{width: 250px;}
		table, tr, td{border: 1px solid black; border-collapse: collapse;}
		.noBorder{border: 0px;}
	</style>
</head>
<body>
	<h2>LoginForm.jsp</h2>
	<fieldset>
		<button onclick="main()">메인으로</button>
		<button onclick="memberJoin()">회원가입</button>
		<button onclick="location.href='/MemberBoard/board/boardList'">글목록조회</button>
	</fieldset><br>
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
		<tr>
			<td colspan="2"><input type="submit" value="로그인"></td>
		</tr>
	</table>
</form>
</body>
<script>
	function login() {
		loginForm.submit();
	}
	function joinForm() {
		location.href = "JoinFrom.jsp";
	}
	function memberJoin() {
		location.href = "/MemberBoard/member/JoinForm.jsp";
	}
	function main() {
		location.href = "/MemberBoard/Main.jsp";
	}
</script>
</html>