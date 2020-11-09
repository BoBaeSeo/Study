<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main.jsp</title>
</head>
<body>
<h2>Main.jsp</h2>
<button onclick="bWrite()">글쓰기</button> <button onclick="bView()">목록조회</button>
</body>
<script type="text/javascript">
	function bWrite(){
		location.href="BoardWrite.jsp"
	}
	function bView(){
		location.href="BoardList"
	}
</script>
</html>