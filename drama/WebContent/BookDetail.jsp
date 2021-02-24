<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="CSS/Main.css">
<script src="https://kit.fontawesome.com/93b11a64f8.js"
	crossorigin="anonymous"></script>
<style>
form {
	text-align: center;
}

table {
	width: 1000px;
	height: 500px;
}

#main {
	margin: auto;
	text-align: center;
}

#contents {
	vertical-align: middle;
	display: inline-block;
	height: 700px;
}

#tkList {
	width: 1000px;
	height: 200px;
	margin: 20px;
}

#dname {
	width: 400px;
}
</style>
</head>
<body>
	<!-- 메뉴바 -->
	<div id="box">

		<div id="menu">
			<c:choose>
				<c:when test="${sessionScope.idCheck == null}">
					<div id="login">
						<form action="MemberLogin" method="post">
							<label for="label_id"><span class="title">ID </span></label><input
								type="text" id="label_id" name="id"> <br> <label
								for="label_pw"><span class="title">PW </span></label><input
								type="password" id="label_pw" name="pw"> <br>
							<div id="btn_1">
								<button class="btn" type="button"
									onclick="location.href='JoinForm.jsp'">회원가입</button>
								<button class="btn" onclick="submit">로그인</button>
							</div>
						</form>
					</div>
					<br>
				</c:when>
				<c:otherwise>
					<div id="logo">



						<span class="title">${sessionScope.idCheck}님</span> <span
							id="level"><img
							src="File/Grade/${sessionScope.idRank}.gif" alt="등급"></span>
						<div>
							<button type="button" onclick="location.href='MemberLogout'"
								class="btn">로그아웃</button>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			<nav id="nav">
				<ul>
					<li><a id="top-link" onclick="LoginCheck()">예매하기</a></li>
					<br>
					<br>
					<li><a href="#" id="portfolio-link" onclick="LoginCheck2()">회원수정</a></li>
					<br>
					<br>
					<li><a id="about-link" onclick="LoginCheck3()">예매내역</a></li>
					<br>
					<br>
					<li><a id="contact-link" onclick="LoginCheck4()">회원탈퇴</a></li>
				</ul>
			</nav>
			<br><br>
			<p>연극 검색</p>
			<div id="search">
				<form method="get" action="Search">
					<input name="dname"> <input type="submit" value="검색">
				</form>
			</div>
		</div>
        
        <div id="banner">
        <div id="mark">
        	<a href="Main.jsp">
			<img width="200" id="Drama" src="File/logo.png">
			</a>
        </div>
        </div>


		<div id="main">
			<div id="contents">
				<h1>예매확인.jsp</h1>
				<table>
					<tr>
						<td rowspan="7"><img src="File/${info.dname}.jpg"
							width="130px" height="200px"></td>
						<td>영화제목</td>
						<td>${info.dname}</td>
					</tr>
					<tr>
						<td>예매자</td>
						<td>${info.name}</td>
						<td>핸드폰번호</td>
						<td>${info.phone}</td>
					</tr>
					<tr>
						<td>예매번호</td>
						<td>${info.tcode}</td>
						<td>(총 ${info.tnum} 매)</td>
					</tr>
					<tr>
						<td>감독이름</td>
						<td>${info.director}</td>
						<td>장르</td>
						<td>${info.genre}</td>
					</tr>
					<tr>
						<td>러닝타임</td>
						<td>${info.runtime}</td>
					</tr>
					<tr>
						<td>상영날짜</td>
						<td>${info.showdate}</td>
					</tr>
					<tr>
						<td>총 예매 가격</td>
						<td>${info.price * info.tnum}</td>
					</tr>
				</table>
				<input type="button" onclick="cancelDrama()" value="예매 취소">
			</div>
		</div>
	</div>
</body>
<script>
	function cancelDrama() {
		var getPw = prompt('비밀번호를 입력해주세요');
		var userPw = '${userPw }';
		if (getPw == userPw) {
			location.href = "/drama/cancelDrama?tcode=${info.tcode}&tnum=${info.tnum}&dcode=${info.dcode}";
		} else {
			alert('비밀번호가 일치하지 않습니다.')
		}
	}
	function LoginCheck(){
		location.href = "DramaList";
}
function LoginCheck2(){

	if(${sessionScope.idCheck == null}){
		alert("로그인후 이용해 주세요.");
	} else{
		location.href = "Modify";
	}
}
function LoginCheck3(){
	if(${sessionScope.idCheck == null}){
		alert("로그인후 이용해 주세요.");
	} else{
		location.href = "TicketList";
	}
}
function LoginCheck4(){
	if(${sessionScope.idCheck == null}){
		alert("로그인후 이용해 주세요.");
	} else{
		location.href = "Modify";
	}
}
function MemberJoin(){
	location.href="JoinForm.jsp";
}
	
</script>
</html>