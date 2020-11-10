<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WriteList.jsp</title>
<style>
	table, tr, td{border: 1px solid black; border-collapse: collapse;}
	fieldset{width: 250px; }
</style>
</head>
<body>
	<h2>WriteList.jsp</h2>
	<fieldset>
		<legend><%=session.getAttribute("checkId") %>님 환영합니다.</legend>
		<button onclick="main()">메인으로</button> <button onclick="modify()">회원수정</button> <button onclick="logout()">로그아웃</button>
	</fieldset><br>
	<table>
		<tr>
			<th>글번호</th>
			<th>이미지</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="list" items="${writeList}">
			<tr>
				<td>${list.bNumber}</td>
				<td><img src = "../fileupload/${list.bFile}" alt="${list.bFile}" width ="50" height ="50"><br></td>
				<td><a href="/board/boardView">${list.bTitle}</a></td>
				<td>${list.bWriter}</td>
				<td>${list.bDate}</td>
				<td>${list.bHits}</td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="board()">게시판</button> 
	<button onclick="boardWrite()">글쓰기</button>
</body>
<script>
	function main() {
		location.href = "/MemberBoard/Main.jsp";
	}
	function modify() {
		location.href = "/MemberBoard/member/memberModify";
	}
	function logout() {
		location.href = "/MemberBoard/member/memberLogout";
	}
	function board(){
		location.href="/MemberBoard/board/boardList";
	}
	function boardWrite(){
		location.href = "/MemberBoard/board/BoardWrite.jsp";
	}
	
</script>
</html>