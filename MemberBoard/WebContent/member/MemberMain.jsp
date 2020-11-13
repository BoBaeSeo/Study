<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberMain.jsp</title>
<style>
fieldset{width: 370px;}
</style>
</head>
<body>
	<h2>MemberMain.jsp</h2>
	<fieldset>
		<legend><%=session.getAttribute("checkId") %>님 환영합니다.</legend>
		<button onclick="main()">메인으로</button>
		<button onclick="modify()">회원수정</button>
		<button onclick="board()">게시판</button>
		<button onclick="delUser()">회원탈퇴</button>
		<button onclick="logout()">로그아웃</button>
	</fieldset>
</body>
<script>
	function main(){
		location.href="/MemberBoard/Main.jsp";
	}		
	function modify(){
		location.href="/MemberBoard/member/memberModify";
	}
	function board(){
		location.href="/MemberBoard/board/boardList";
	}
	function logout(){
		location.href="/MemberBoard/member/memberLogout";
	}
	function delUser(){
		location.href="/MemberBoard/member/memberDelete";
	}
</script>
</html>