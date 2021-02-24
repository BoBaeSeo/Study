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
        td{width: 50px;}
        #main{margin: auto; text-align: center;}
        #join{vertical-align: middle; display:inline-block; height: 700px;}
    </style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
<link rel="stylesheet" href="CSS/Main.css">
<script src="https://kit.fontawesome.com/93b11a64f8.js" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#userId").keyup(function(){
			var idCheck = $("#userId").val();
			if (idCheck.length > 0){
				$.ajax({
					type : "get",
					url : "checkId",
					data : {"uId" : idCheck },
					success : function(data){
						console.log("data:" + data);
						if(data == "OK"){
							$("#confirmId").css("color", "green").text("사용가능");
						} else {
							$("#confirmId").css("color", "red").text("사용 불가능");
						}
					},
					error : function(){
						console.log("노전송")
					}
				})
			} else {
				$("#confirmId").css("color", "red").text("")
			}
		})
	})
</script>
</head>
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
                <div id="btn_1"><button type="button" onclick="location.href='JoinForm.jsp'"class="btn">회원가입</button> <input type="submit" class="btn" value="로그인"></div>
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
            <h1 style="text-align: center;">회원가입</h1>
            <div id="join">
            <form action="MemberJoin" method="post">
                <table>
                    <tr>
                        <td>아이콘</td>
                        <td>이름</td>
                        <td><input type="text" name="userName" placeholder="ex)홍길동" required></td>
                    </tr>
                    <tr>
                        <td>아이콘</td>
                        <td>아이디</td>
                        <td><input type="text" name="userId" id="userId" placeholder="6~10자리" required><br><span id="confirmId"></span></td>
                    </tr>
                    <tr>
                        <td>아이콘</td>
                        <td>비밀번호</td>
                        <td><input type="password" name="userPw" placeholder="6~10자리" required></td>
                    </tr>
                    <tr>
                        <td>아이콘</td>
                        <td>전화번호</td>
                        <td><input type="text" name="userPhone" placeholder="ex)010-0000-0000" required></td>
                    </tr>
                    <tr>
                        <td>아이콘</td>
                        <td>생년월일</td>
                        <td><input type="date" name="userBirth" required></td>
                    </tr>
                    <tr>
                        <td colspan="3" style="text-align: center;"><input type="submit" id="apply" value="회원가입"></td>
                    </tr>
                </table>
            </form>
        </div>



        </div>

	</div>

</body>
<script>
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