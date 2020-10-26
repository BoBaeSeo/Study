<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Calendar" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Time</title>
<%
	Calendar cal = Calendar.getInstance(); /* new Calendar(); */
	int hour = cal.get(Calendar.HOUR_OF_DAY);
	int min = cal.get(Calendar.MINUTE);
	int sec = cal.get(Calendar.SECOND);
%>
</head>
<body>
	<h1>현재시간은 <%=hour %>시 <%=min %>분 <%=sec %>초 입니다.</h1>
</body>
</html>