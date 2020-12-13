<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h2> <a href="selectTest">selectTest</a></h2>

<form action="insertTest" method="get">
이름 :<input type="text" name="name"><br>
나이 :<input type="text" name="age"><br>
주소 :<input type="text" name="addr"><br>
<input type="submit" value="insertTest">
</form>
<form action="selectTest2" method="get">
나이 :<input type="text" name="age"><br>
<input type="submit" value="selectTest2">
</form>
</body>
</html>
