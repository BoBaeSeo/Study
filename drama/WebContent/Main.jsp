<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
	crossorigin="anonymous"></script>
<style>
#main {
	margin: auto;
	text-align: center;
}

#img {
	vertical-align: middle;
	display: inline-block;
	height: 700px;
}

@import url(https://fonts.googleapis.com/css?family=Raleway:400,500,800)
	;

figure.snip1132 {
	font-family: 'Raleway', Arial, sans-serif;
	position: relative;
	overflow: hidden;
	margin: 10px;
	min-width: 200px;
	max-width: 280px;
	max-height: 280px;
	/*  width: 100%; */
	width: fit-content;
	background: #000000;
	color: #ffffff;
	text-align: center;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
}

figure.snip1132 * {
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	-webkit-transition: all 0.45s ease-in-out;
	transition: all 0.45s ease-in-out;
}

figure.snip1132 img {
	max-width: 100%;
	position: relative;
	opacity: 1;
}

figure.snip1132 figcaption {
	position: absolute;
	top: 20px;
	left: 20px;
	right: 20px;
	bottom: 20px;
	border: 1px solid white;
	border-width: 0 1px;
}

figure.snip1132 .heading {
	overflow: hidden;
	-webkit-transform: translateY(-50%);
	transform: translateY(-50%);
}

figure.snip1132 .caption {
	overflow: hidden;
	-webkit-transform: translateY(50%);
	transform: translateY(50%);
	position: absolute;
	width: 100%;
	bottom: 0;
}

figure.snip1132 h3, figure.snip1132 p {
	display: table;
	margin: 0 auto;
	padding: 0 10px;
	position: relative;
	text-align: center;
	width: auto;
	text-transform: uppercase;
	font-weight: 400;
}

figure.snip1132 h3 span, figure.snip1132 p span {
	font-weight: 800;
}

figure.snip1132 h3:before, figure.snip1132 p:before, figure.snip1132 h3:after,
	figure.snip1132 p:after {
	position: absolute;
	display: block;
	width: 1000%;
	height: 1px;
	content: '';
	background: white;
}

figure.snip1132 h3:before, figure.snip1132 p:before {
	left: -1000%;
}

figure.snip1132 h3:after, figure.snip1132 p:after {
	right: -1000%;
}

figure.snip1132 h3:before, figure.snip1132 h3:after {
	top: 50%;
}

figure.snip1132 p {
	font-size: 0.8em;
	font-weight: 500;
}

figure.snip1132 p:before, figure.snip1132 p:after {
	bottom: 50%;
}

figure.snip1132 a {
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	position: absolute;
	z-index: 1;
}

figure.snip1132:hover img, figure.snip1132.hover img {
	opacity: 0.35;
	-webkit-transform: scale(1.15);
	transform: scale(1.15);
}

</style>
<script type="text/javascript">
$(".hover").mouseleave(
	    function () {
	      $(this).removeClass("hover");
	    }
	  );
</script>
</style>
</head>
<link rel="stylesheet" href="CSS/Main.css">
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
				<a href="Main.jsp"> <img width="200" id="Drama"
					src="File/logo.png">
				</a>
			</div>
		</div>


		<div id="main">
			<h1>현재 상영중</h1>
			<div id="img">
				<!-- 대충 사진 넣는 곳 -->
				<table>
					<tr>
						<td>
							<figure class="snip1132">
								<img width="220" height="300" src="File/옥탑방고양이.jpg"
									alt="sample18" />
								<a href="DramaView?dcode=1"></a>
							</figure>
						</td>
						<td>
							<figure class="snip1132">
								<img width="220" height="300" src="File/2호선세입자.jpg"
									alt="sample18" />
								<a href="DramaView?dcode=2"></a>
							</figure>
						</td>
						<td>
							<figure class="snip1132">
								<img width="220" height="300" src="File/그남자그여자.jpg"
									alt="sample18" />
								<a href="DramaView?dcode=3"></a>
							</figure>
						</td>
					<tr>
						<td>
							<figure class="snip1132">
								<img width="220" height="300" src="File/행오버.jpg" alt="sample18" />
								<a href="DramaView?dcode=4"></a>
							</figure>
						</td>
						<td>
							<figure class="snip1132">
								<img width="220" height="300" src="File/한뼘사이.jpg" alt="sample18" />
								<a href="DramaView?dcode=5"></a>
							</figure>
						</td>
						<td>
							<figure class="snip1132">
								<img width="220" height="300" src="File/뷰티풀라이프.jpg"
									alt="sample18" />
								<a href="DramaView?dcode=6"></a>
							</figure>
						</td>
				</table>

			</div>
			<div id="foot">
				<!-- 대충밑에칸 -->

			</div>



		</div>

	</div>

</body>
<script type="text/javascript">
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
</script>
</html>