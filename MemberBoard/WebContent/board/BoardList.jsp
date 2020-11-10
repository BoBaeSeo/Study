<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList.jsp</title>
<style>
	table, tr, td{border: 1px solid black; border-collapse: collapse;}
	fieldset{width: 250px; }
</style>
</head>
<body>
	<h2>BoardList.jsp</h2>
	<fieldset>
		<c:if test="${sessionScope.checkId != null}">
		<legend><%=session.getAttribute("checkId") %>님 환영합니다.</legend>
		</c:if>
		<button onclick="main()">메인으로</button> 
		<c:choose>
			<c:when test="${sessionScope.checkId != null}">
				<button onclick="modify()">회원수정</button> <button onclick="logout()">로그아웃</button>
			</c:when>
			<c:otherwise>
				<button onclick="join()">회원가입</button> <button onclick="login()">로그인</button>
			</c:otherwise>
		</c:choose>
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
		<c:forEach var="list" items="${boardList}">
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
	<c:if test="${sessionScope.checkId != null}">
	<button onclick="userWrite()">내가쓴글</button> 
	</c:if>
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
	function userWrite(){
		location.href = "/MemberBoard/board/userWrite";
	}
	function boardWrite(){
		if(${sessionScope.checkId == null}){
			alert("로그인이 필요합니다.");
		} else {
			location.href = "/MemberBoard/board/BoardWrite.jsp";
		}
	}
	function join(){
		location.href = "/MemberBoard/member/JoinForm.jsp";
	}
	function login(){
		location.href = "/MemberBoard/member/LoginForm.jsp";		
	}
	
</script>
</html>