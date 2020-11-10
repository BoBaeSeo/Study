<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardWrite.jsp</title>
<style>
	table, tr, td{border: 1px solid black; border-collapse: collapse;}
</style>
</head>
<body>
	<h2>BoardWrite.jsp</h2>
	<form action="boardWrite" method="post" name="boardWrite" enctype="multipart/form-data">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="hidden" name="bWriter" value=${sessionScope.checkId }>${sessionScope.checkId }</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="bPassword" required></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle"></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td><textarea rows="20" cols="30" name="bContents"></textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="bFile"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글등록">
				<input type="button" value="글목록" onclick="boardList()"></td>
			</tr>
		</table>
	</form>
</body>
<script>
	function boardList(){
		location.href="/MemberBoard/board/boardList";
	}
</script>
</html>