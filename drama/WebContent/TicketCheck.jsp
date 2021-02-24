<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, td {
	border: 1px solid black;
	border-collapse: collapse;
}
#main{
margin:auto;
text-align:center;

}
#List{
width:70%;
vertical-align:middle;
display:inline-block;
height:700px;
margin:auto;
}#check table{
	margin: auto;
	margin-bottom : 5%;
}tr,td{
	padding: 1%
}
</style>
<link rel="stylesheet" href="CSS/Main.css">
</head>

<body>
<div id="box">

        <div id="menu">
         <c:choose>
            <c:when test="${sessionScope.idCheck == null}">
            <div id="login">
            <form action="MemberLogin" method="post">
                <label for="label_id"><span class="title">ID </span></label><input type="text" id="label_id" name="id"> <br>
                <label for="label_pw"><span class="title">PW </span></label><input type="password" id="label_pw" name="pw"> <br>
                <div id="btn_1"><button type="button" onclick="MemberJoin()"class="btn">회원가입</button> <input type="submit" class="btn" value="로그인"></div>
                </form>
            </div>
            <br>
            </c:when>
            <c:otherwise>
            <div id="logo">
            
            
            
                <span class="title">${sessionScope.idCheck}님</span>
                
                
                
                <span id="level"><img src="File/Grade/${sessionScope.idRank}.gif" alt="등급"></span>
                <div><button class="btn" >로그아웃</button> </div>
            </div>
            </c:otherwise>
        </c:choose>
        <nav id="nav">
            <ul>
                <li><a href="#1"  id="top-link" onclick="LoginCheck()">예매하기</a></li>
                <br><br>
                <li><a id="portfolio-link" onclick="LoginCheck2()">회원수정</a></li>
                <br><br>
                <li><a id="about-link" onclick="LoginCheck3()">예매내역</a></li>
                <br><br>
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
<div id="List">
	<form action="TicketCheckProcess" method="post"
		>
<h1>예매 내역 확인</h1>
		<div id="check">
		<table>

			<tr>
			
				<td>영화제목</td>
				<td>${dramaDTO.dname}<input type="hidden"
					value="${dramaDTO .dname}" name="dname"> <input
					type="hidden" value="${dramaDTO.dcode}" name="dcode">
				</td>
			</tr>
			<tr>
				<td>영화이미지</td>
				<td><img src="/drama/File/${dramaDTO.files}" width="200">
					<input type="hidden" value="${dramaDTO.files}" name="files"></td>
			</tr>



			<tr>
				<td>감독이름</td>
				<td>${dramaDTO.director}<input type="hidden"
					value="${dramaDTO.director}" name="director">
				</td>
			</tr>

			<tr>
				<td>장르</td>
				<td>${dramaDTO.genre}<input type="hidden"
					value="${dramaDTO.genre}" name="genre">
				</td>
			</tr>

			<tr>
				<td>시청나이</td>
				<td>${dramaDTO.age}<input type="hidden" value="${dramaDTO.age}"
					name="age">
				</td>
			</tr>

			<tr>
				<td>러닝타임</td>
				<td>${dramaDTO.runtime}<input type="hidden"
					value="${dramaDTO.runtime}" name="runtime">
				</td>
			</tr>

			<tr>
				<td>상영날짜</td>
				<td>${dramaDTO.showdate}<input type="hidden"
					value="${dramaDTO.showdate}" name="showdate">
				</td>
			</tr>


			<tr>
				<td>핸드폰번호</td>
				<td>${memberDTO.phone}<input type="hidden"
					value="${memberDTO.phone}" name="phone"></td>
			</tr>



			<tr>
				<td>이름</td>
				<td>${memberDTO.name}<input type="hidden"
					value="${InfoDTO.name}" name="name"> 
					<input type="hidden"
					value="${memberDTO.mcode}" name="mcode">
				</td>

			</tr>

			<tr>
				<td>매수</td>
				<td>${Tnum}
				<input type="hidden" value="${Tnum}"
					name="tnum"></td>
			</tr>

			<tr>
				<td>가격</td>
				<td>${dramaDTO.price}<input type="hidden"
					value="${dramaDTO.price}" name="price"></td>
			</tr>


		</table>
		<input type="submit" value="예매하기"> <input type="button"
			onclick="history.back(-1)" value="취소하기">
		</div>
	</form>
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