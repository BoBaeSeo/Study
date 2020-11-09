<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberMain.jsp</title>
</head>
<body>
<h2>MemberMain.jsp</h2>
<h3><%=session.getAttribute("loginId") %>님 환영합니다.</h3>
<h3>${sessionScope.loginId}님 환영합니다.</h3>
<button onclick="memberModify()">회원수정</button>
<a href="memberList">회원목록조회</a>
<button onclick="memberLogout()">로그아웃</button>
</body>
<script>
	function memberModify(){
		location.href="memberModify";
	}
	function memberLogout(){
		location.href="memberLogout";
	}
</script>
</html>