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
<h2>회원정보 수정하기</h2>
<p>회원 아이디: ${member.userId}</p>
<p>회원 비밀번호: ${member.userPw}</p>
<p>회원 이름: ${member.userName}</p>
<p>회원 생년월일: ${member.userBirth}</p>
<p>회원 성별: ${member.userGender}</p>
<p>회원 이메일: ${member.userEmail}</p>
<form action="modifyUser" method="post" id="modifyForm">
<h3>확인용 비밀번호: <input type="password" name="checkPw"></h3>
<h3>수정할 이름: <input type="text" name="newName"></h3>
<h3>수정할 이메일: <input type="email" name="newEmail"></h3>
</form>
<button onclick="modify()">정보수정</button> <button onclick="main()">메인으로</button>
</body>
<script>
	function modify(){
		modifyForm.submit();
	}
	function main(){
		location.href="MemberMain.jsp";
	}
</script>
</html>