<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardModify.jsp</title>
<style>
	table, tr, td{border: 1px solid black; border-collapse: collapse;}
</style>
</head>
<body>
	<h2>boardModify.jsp</h2>
	<form action="boardUpdate" method="post" id="modify" enctype="multipart/form-data">
		<table>
		<tr>
			<td>글번호</td>
			<td><input type="hidden" name="bNumber" value="${userDTO.bNumber}">${userDTO.bNumber}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="hidden" name="bWriter" value="${sessionScope.checkId}">${sessionScope.checkId}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="bPw" id="pw" required></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="bTitle" required value="${userDTO.bTitle}"></td>
		</tr>
		<tr>
			<td>글내용</td>
			<td><textarea name="bContents" cols="40" rows="20">${userDTO.bContents}</textarea></td>
		</tr>
		<tr>
			<td>파일</td>
			<td><input type="hidden" name="bFile" value="${userDTO.bFile }">
			<c:if test="${userDTO.bFile != null }">
			<img src="/MemberBoard/fileupload/${userDTO.bFile }" width="100" height="100">
			</c:if>
			<br><input type="file" name="newFile"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" onclick="checkPw()" value="글수정"> <input type="button" value="목록" onclick="boardList()"></td>
		</tr>
	</table>
	</form>
</body>
<script>
	function checkPw(){
		var writePw = document.getElementById("pw").value;
		var userPw = "${userDTO.bPassword}";
		if(writePw == userPw){
			modify.submit();
		} else {
			alert("비밀번호가 일치하지 않습니다.");
		}
	}
	function boardList(){
		location.href="/MemberBoard/board/boardList";
	}
</script>
</html>