<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList.jsp</title>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" 
    integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" 
    crossorigin="anonymous"></script>
</head>
<body>
<table id="members">
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>생년월일</td>
		<td>성별</td>
		<td>이메일</td>
		<td>상세조회</td>
		<td>탈퇴</td>
	</tr>
	<c:forEach var="mem" items="${memberList}">
	<tr>
		<td>${mem.userId}</td>
		<td>${mem.userPw}</td>
		<td>${mem.userName}</td>
		<td>${mem.userBirth}</td>
		<td>${mem.userGender}</td>
		<td>${mem.userEmail}</td>
		<td><a href="memberDetail?userId=${mem.userId}">상세조회</a></td><td><a href="memberDelete?userId=${mem.userId}">탈퇴</a></td>
	</tr>
	</form>
	</c:forEach>
</table>
</body>
</html>