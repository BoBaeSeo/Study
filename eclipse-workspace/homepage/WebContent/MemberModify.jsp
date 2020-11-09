<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberModify.jsp</title>
</head>
<body>
<h2>회원정보 수정</h2>
<p>회원 아이디: <c:out value="${member.getUserId()}"></c:out></p>
<p>회원 이름: <c:out value="${member.getUserName()}"></c:out></p>
<p>회원 생년월일: <c:out value="${member.getUserBirth()}"></c:out></p>
<p>회원 성별: <c:out value="${member.getUserGender()}"></c:out></p>
<p>회원 이메일: <c:out value="${member.getUserEmail()}"></c:out></p>
<form action="modifyCheck" method="post">
	<table>
		<tr>
			<td>확인용 비밀번호 :</td>
			<td><input type="password" name="userPw"></td>
		</tr>
		<tr>
			<td>수정할 이름 :</td>
			<td><input type="text" name="userName"></td>
		</tr>
		<tr>
			<td>수정할 이메일 :</td>
			<td><input type="email" name="userEmail"></td>
		</tr>
	</table>
<input type="submit" value="정보수정"> <input type="button" onclick="Main()" value="메인으로">
</form>
</body>
<script>
	function Main(){
		location.href="MemberMain.jsp";
	}
</script>
</html>