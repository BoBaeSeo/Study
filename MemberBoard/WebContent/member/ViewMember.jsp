<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewMember.jsp</title>
</head>
<body>
	<h2>ViewMember.jsp</h2>
	<h2>회원정보 수정하기</h2>
	<p>회원 아이디: ${userInfo.userId}</p>
	<p>회원 비밀번호: ${userInfo.userPw}</p>
	<p>회원 이름: ${userInfo.userName}</p>
	<p>회원 생년월일: ${userInfo.userBirth}</p>
	<p>회원 성별: ${userInfo.userGender}</p>
	<p>회원 이메일: ${userInfo.userEmail}</p>
	<form action="modifyUser" method="post" id="modifyForm">
		<h3>확인용 비밀번호: <input type="password" name="checkPw" id="upw"></h3>
		<h3>수정할 이름: <input type="text" name="newName"></h3>
		<h3>수정할 이메일: <input type="email" name="newEmail"></h3>
	</form>
	<button onclick="memberModify()">정보수정</button> <button onclick="main()">메인으로</button>
</body>
<script>
	function memberModify(){
		var userPw = ${userInfo.userPw}
		var passwordConfirm = document.getElementById("upw").value;
		if(userPw == passwordConfirm){
			modifyForm.submit();
		} else{
			alert("비밀번호가 일치하지않습니다.")
		}
	}
	function main() {
		location.href = "/MemberBoard/Main.jsp";
	}
</script>
</html>