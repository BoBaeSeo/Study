<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardModify.jsp</title>
</head>
<body>
<h1>BoardModify.jsp</h1>
<form action="ModifyContents" method="post" id="modify">
	<table>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="bWriter" required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="bPw" id="pw"required></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="bTitle" required></td>
		</tr>
		<tr>
			<td>글내용</td>
			<td><textarea name="bContents" cols="40" rows="20"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="글수정"> <input type="button" value="목록" onclick="bView()"></td>
		</tr>
	</table>
</form>
</body>
<script>
	function checkPw(){
		var userPw = ${dto.bPassword};
		var getPw = document.getElementById("pw").value;
		if(userPw == getPw){
			alert("수정되었습니다.")
			location.href="updateBoard?bNumber=${dto.bNumber}";
		} else{
			alert("비밀번호가 일치하지 않습니다.")
		}
	}
	function bView(){
		location.href="BoardList"
	}
</script>
</html>