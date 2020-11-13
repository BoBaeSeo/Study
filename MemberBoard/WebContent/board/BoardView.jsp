<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardView.jsp</title>
<style>
table, tr, td{border: 1px solid black; border-collapse: collapse;}
</style>
</head>
<body>
	<h2>BoardView.jsp</h2>
	<table>
		<tr>
			<td>제목</td>
			<td>${boardView.bTitle }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${boardView.bWriter }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${boardView.bContents }</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${boardView.bHits }</td>
		</tr>
		<tr>
			<c:if test ="${boardView.bFile != null}">
			<td>파일</td>
			<td><img src="../fileupload/${boardView.bFile }" width="200">
			<br>
			</td>
			</c:if>
		</tr>
	</table>
	<input onclick="boardList()" type="button" value="전체 목록">
	<c:if test="${sessionScope.checkId == boardView.bWriter }">
	<input onclick="boardModify()" type="button" value="수정">
	<input onclick="boardDel()" type="button" value="삭제">
	</c:if>
</body>
<script>
	function boardList(){
		location.href="/MemberBoard/board/boardList";
	}
	function boardModify(){
		location.href="/MemberBoard/board/boardModify?bNumber=${boardView.bNumber}";
	}
	function boardDel(){
		var writePw = prompt("비밀번호를 입력하세요");
		var boardPw = ${boardView.bPassword};
		if(writePw == boardPw){
			location.href="/MemberBoard/board/boardDel?bNumber=${boardView.bNumber}&bFile=${boardView.bFile}";			
		} else {
			alert("비밀번호가 일치하지않습니다.")
		}
	}
</script>
</html>