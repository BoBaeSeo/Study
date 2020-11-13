<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewMember.jsp</title>
<style>
	table, tr, td, th{border: 1px solid black; border-collapse: collapse;}
	th{text-align: center;}
</style>
</head>
<body>
	<h2>ViewMember.jsp</h2>
	<h2>회원정보 수정하기</h2>
	<form action="modifyUser" method="post" id="modifyForm">
		<table>
			<tr>
				<th>아이디</th><td>${userInfo.userId }</td>
			</tr>
			<tr>
				<th>비밀번호</th><td><input type="text" name="newPw"></td>
			</tr>
			<tr>
				<th>이름</th><td><input type="text" name="newName" value="${userInfo.userName }"></td>
			</tr>
			<tr>
				<th>생년월일</th><td><input type="date" name="newBirth" value="${userInfo.userBirth }"></td>
			</tr>
			<tr>
				<th>성별</th><td>${userInfo.userGender }</td>
			</tr>
			<tr>
				<th>이메일</th><td><input type="email" name="newEmail" value="${userInfo.userEmail }"></td>
			</tr>
		</table>
	</form>
	<button onclick="memberModify()">정보수정</button> <button onclick="main()">메인으로</button>
</body>
<script>
	function memberModify(){
		var userPw = ${userInfo.userPw}
		var passwordConfirm = prompt("비밀번호를 입력해주세요");
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