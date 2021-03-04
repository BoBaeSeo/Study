<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        form{text-align: center;}
        table{width: 1000px; height: 500px; }
        #main{margin: auto; text-align: center;}
        #contents{vertical-align: middle; display:inline-block; height: 700px;}
        #tkList{width: 1000px; height: 200px; margin: 20px;}
        #dname{width: 400px;}
    </style>
</head>
<link rel="stylesheet" href="CSS/Main.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/93b11a64f8.js" crossorigin="anonymous"></script>
<body>
<!-- 메뉴바 -->
    <div id="box">
	  <div id="menu">
         <c:choose>
            <c:when test="${sessionScope.idCheck == null}">
            <div id="login">
            	<form action="MemberLogin" method="post">
                <label for="label_id"><span class="title">ID </span></label><input type="text" id="label_id" name="id"> <br>
                <label for="label_pw"><span class="title">PW </span></label><input type="password" id="label_pw" name="pw"> <br>
                <div id="btn_1"><button class="btn" type="button" onclick="location.href='JoinForm.jsp'">회원가입</button> <button class="btn" onclick="submit">로그인</button></div>
                </form>
            </div>
            <br>
            </c:when>
            <c:otherwise>
            <div id="logo">
            
            
            
                <span class="title">${sessionScope.idCheck}님</span>
                
                
                
                <span id="level"><img src="File/Grade/${sessionScope.idRank}.gif" alt="등급"></span>
                <div><button type="button" onclick="location.href='MemberLogout'" class="btn">로그아웃</button> </div>
            </div>	
            </c:otherwise>
        </c:choose>
        <nav id="nav">
            <ul>
                <li><a  id="top-link" onclick="LoginCheck()">예매하기</a></li>
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
			<h1 style="text-align: center;">예매 내역</h1>
			<div id="contents" style="overflow: auto;">
					<c:choose>
						<c:when test="${ok != null }">
							<c:forEach var="info" items="${infoList }">
							<table id="tkList">
								<tr>
									<td rowspan="4"><img src="File/${info.files}" width="130px" height="200px"></td>
									<td colspan="2" id="dname">${info.dname }</td>
									<td><button onclick="location.href='/drama/bookDetail?tcode=${info.tcode}'">상세보기</button></td>
								</tr>
								<tr>
									<td>예매코드 : ${info.tcode }</td>
									<td>장르 : ${info.genre }</td>
									<td>감독 : ${info.director }</td>
								</tr>
								<tr>
									<td>상영 날짜 : ${info.showdate }</td>
								</tr>
								<tr>
									<td>구매 날짜 : ${info.buyDate }</td>
									<td>${info.tnum }매</td>
									<td>${info.price * info.tnum }원</td>
								</tr>
							</table>
							<hr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td><p>예매 내역이 존재하지 않습니다.</p></td>
							</tr>
						</c:otherwise>
					</c:choose>
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
	function MemberJoin(){
		location.href="JoinForm.jsp";
	}
	

</script>
</html>