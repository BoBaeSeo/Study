<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testMain.jsp</title>
<style>
	table, tr, td{
	border: 1px solid black;
	border-collapse: collapse;
	}
	td{
	padding: 10px;
	}
</style>
</head>
<body>
<h2>testMain</h2>
<table>
	<tr>
		<td><button onclick="insertForm()">입력</button></td>
		<td><button onclick="selectTest()">출력</button></td>
	</tr>
</table>
</body>
<script>
	function insertForm(){
		location.href="insertForm";
	}
	function selectTest(){
		location.href="selectTest";
	}
</script>
</html>