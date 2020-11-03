<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JoinForm.jsp</title>
</head>
<body>
<h1>JoinForm.jsp</h1>
<h3>action="memberJoin" method="post"</h3>
<h3>Servlet = controller패키지 > MemberJoinController</h3>
<h1>회원가입</h1>
<form action="memberJoin" method="post">
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
		<td>이름</td>
		<td><input type="text" name="userName"></td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td><input type="date" name="userBirth"></td>
	</tr>
	<tr>
		<td>성별</td>
		<td><label><input type="radio" name="userGender" value="남">남자</label>
			<label><input type="radio" name="userGender" value="여">여자</label></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="email" name="userEmail"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="회원가입"> <input type="reset" value="다시작성"></td>
	</tr>
</table>
</form>
</body>
</html>