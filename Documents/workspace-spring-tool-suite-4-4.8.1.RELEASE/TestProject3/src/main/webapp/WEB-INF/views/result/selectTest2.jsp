<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>selectTest2.jsp</title>
</head>
<body>
<h2>${age }보다 나이가 많으면 출력</h2>
<c:forEach var="list" items="${dto}">
이름: ${list.name }<br>
나이: ${list.age }<br>
주소: ${list.addr }<br><hr>
</c:forEach>
</body>
</html>