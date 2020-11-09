<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardView.jsp</title>
<style type="text/css">
table, tr, td{border: 1px solid black; border-collapse:collapse; padding: 5px;}
</style>
</head>
<body>
<h2>BoardView.jsp</h2>
<table>
	<tr>
		<td>제목</td>
		<td>${dto.bTitle}</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${dto.bWriter}</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>${dto.bContents}</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${dto.bHits}</td>
	</tr>
</table><br>
<button onclick="list()">목록</button> <button onclick="modify()">수정</button> <button>삭제</button>
</body>
<script>
	function list(){
		location.href="BoardList";
	}
	function modify(){
		location.href="BoardModify?bNumber=${dto.bNumber}";
	}
	
</script>
</html>