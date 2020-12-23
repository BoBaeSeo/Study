<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DramaList.jsp</title>
<style>
table{
	margin : auto;
	width: 750px; height: 500px; 
}tr,td{
	margin: 30px;
	padding: 10px;
	margin: 10px;
	font-size : 20px;
}#main{
	margin: auto; text-align: center;
}#contents{
	vertical-align: middle; display:inline-block; height: 700px; padding: 1%}

.red{
	color: red;
}
#file{
	padding-left: 35px;
	padding-right: 35px;
}
#td1{
	padding-bottom: 30px;
	border-bottom : 1px solid white;
}
#td2{
	padding-top: 30px;
}
</style>
<link rel="stylesheet" href="CSS/Main.css">
<script src="https://kit.fontawesome.com/93b11a64f8.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 메뉴바 -->
    <div id="box" style="overflow: atuo;">

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
                <li><a href="#" id="portfolio-link" onclick="LoginCheck2()">회원수정</a></li>
                <br><br>
                <li><a id="about-link" onclick="LoginCheck3()">예매내역</a></li>
                <br><br>
                <li><a id="contact-link" onclick="LoginCheck4()">회원탈퇴</a></li>
            </ul>
        </nav>
        </div>
        
        <div id="banner">
        <div id="mark">
        	<a href="Main.jsp">
			<img width="100" id="Drama" src="File/Logo.png">
			</a>
        </div>

        <div id="search">
        	<form method="get" action="Search">
         		<input name="dname">
         		<input type="submit" value="검색">
    		</form>
        </div>
        </div>
        
        
		<div id="main">
            <h1 style="text-align: center;">연극 리스트</h1>
			<div id="contents" style="overflow: auto;">
	
				<form action="DramaList" method="post">
					<table>
						<c:forEach var="dList" items="${DramaList }">
						<tr>
							<td rowspan="4" id="file" style="border-bottom : 1px solid white"><img src="File/${dList.files }" width="100px" height="160px" onclick="location.href='DramaView?dcode=${dList.dcode}'" ></td>
							<td id="td2"><span class="red">제목</span>  ${dList.dname }</td>
							<td id="td2">러닝타임  ${dList.runtime }분</td>
						</tr>
						
						<tr>
							<td>감독  ${dList.director }</td>
							<td>시청등급  ${dList.age }세 이상 관람가 </td>
						</tr>
						
						<tr>
							<td><span class="red">연극코드</span>  ${dList.dcode } </td>
							<td>조회수  ${dList.hits }</td>
						</tr>
						<tr>
							<td id="td1" ><span class="red">가격</span>  ${dList.price }원</td>
							<td id="td1">장르  ${dList.genre }</td>
							<td style="border-bottom : 1px solid white"><button type="button" onclick="location.href='DramaView?dcode=${dList.dcode}'">예매</button></td>
						</tr>
						</c:forEach>
					</table>
					<hr>		
				</form>
			</div>
        </div>
 

</div>
</body>
<script>

function Main() {
	location.href = "Main.jsp";
}
function List() {
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