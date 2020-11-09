<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardWrite.jsp</title>
<style>
table, tr, td{border: 1px solid black; border-collapse:collapse;}
</style>
</head>
<body>
<h2>BoardWrite.jsp</h2>
<form action="bWrite" method="post">
	<table>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="bWriter" required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="bPw" required></td>
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
			<td colspan="2"><input type="submit" value="글등록"> <input type="button" value="목록" onclick="bView()"></td>
		</tr>
	</table>
</form>
</body>
<script>
	function bView(){
		location.href="BoardList"
	}
</script>
</html>