<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main.jsp</title>
<style>
fieldset{width: 230px;}
</style>
</head>
<body>
	<h2>Main.jsp</h2>
	<fieldset>
		<button onclick="memberJoin()">회원가입</button>
		<button onclick="memberLogin()">로그인</button>
		<button onclick="location.href='/MemberBoard/board/boardList'">글목록조회</button>
	</fieldset>
</body>
<script>
	function memberJoin(){
		location.href="/MemberBoard/member/JoinForm.jsp";
	}		
	function memberLogin(){
		location.href="/MemberBoard/member/LoginForm.jsp";
	}
</script>
</html>