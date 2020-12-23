<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="CSS/Membermodify.css">
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
            <form action="ModifyProcesser" method="POST">
            <div id="modify">
                <div id="modify_info">
                    <div id="modify_info_result">
                        <span class="info_result"><label for="name">이름</label><input type="text" id="name" name="name" value="${Modify.name }"></span> <br><br><br>                    
                        <span class="info_result"><label for="id">아이디</label><input type="text" id="id" name="id" value="${Modify.id }"></span> <br><br><br>
                        <span class="info_result"><label for="pw">비밀번호</label><input type="password" id="pw" name="pw" value="${Modify.pw }"></span> <br><br><br>
                        <span class="info_result"><label for="phone">연락처</label><input type="text" id="phone" name="phone" value="${Modify.phone }"></span> <br><br><br>
                        <span class="info_result"><label for="birth">생년월일</label><input type="date" id="birth" name="birth" value="${Modify.birth }"></span> <br><br><br>
                        <br><br><br><br><br>
                    </div>
                </div>
                <div id="modify_btn">
                    <div id="modify_btn_result">
                        <input type="submit" value="변경하기">
                        
                        <input type="button" value="취소하기" onclick="location.href='Main.jsp'">
                    </div>
                </div>
            </form>                  
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