<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="CSS/Dramaview.css">
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
<!--  여기서부터 메인창 수정 부분 -->
		<div id="main">
            <div id="post">
                <img src="File/${dramaInfo.files }" alt="사진 ㅎㅎ;">
            </div>

            <div id="info">
                연극제목 : ${dramaInfo.dname } <br><br>
                연극감독 : ${dramaInfo.director } <br><br>
                러닝타임 : ${dramaInfo.runtime } <br><br>
                연극장르 : ${dramaInfo.genre } <br><br>
                연극등급 :  ${dramaInfo.age } <br><br>
            </div>

            <div id="comments">
                <div id="grade">
				     <c:choose>
						<c:when test="${requestScope.grade >=4.7}"> 
						평점 : ${ requestScope.grade} <span class="grade_img"><img alt="4.5" src="File/AvgGrade/4.5점.gif"></span>
						</c:when>
						<c:when test="${requestScope.grade >=4.2}"> 4.2>4.0
						평점 : ${ requestScope.grade} <span class="grade_img"><img alt="4" src="File/AvgGrade/4점.gif"></span>
						</c:when>
						<c:when test="${requestScope.grade >=3.7}">
						평점 : ${ requestScope.grade} <span class="grade_img"><img alt="3.5" src="File/AvgGrade/3.5점.gif"></span>
						</c:when>
						<c:when test="${requestScope.grade >=3.2}">
						평점 : ${ requestScope.grade} <span class="grade_img"><img alt="3" src="File/AvgGrade/3점.gif"></span>
						</c:when>
						<c:when test="${requestScope.grade >=2.7}">
						평점 : ${ requestScope.grade} <span class="grade_img"><img alt="2.5" src="File/AvgGrade/2.5점.gif"></span>
						</c:when>
						<c:when test="${requestScope.grade >=2.2}">
						평점 : ${ requestScope.grade} <span class="grade_img"><img alt="2" src="File/AvgGrade/2점.gif"></span>
						</c:when>
						<c:when test="${requestScope.grade >=1.7}">
						평점 : ${ requestScope.grade} <span class="grade_img"><img alt="1.5" src="File/AvgGrade/1.5점.gif"></span>
						</c:when>
						<c:when test="${requestScope.grade >=1.2}">
						평점 : ${ requestScope.grade} <span class="grade_img"><img alt="1" src="File/AvgGrade/1점.gif"></span> 
						</c:when>
						<c:otherwise>
						평점 : ${ requestScope.grade} <span class="grade_img"><img alt="5" src="File/AvgGrade/5점.gif"></span>
						</c:otherwise>
					</c:choose>	
					
                </div>
                <div id="commentsAdd">
                    <form action="Comments" method="post" id="comments_from">
                    <div id="commentsAdd_content">
                        <input type="text" name="comments" placeholder="한줄평을 남기세요"></div>
                    <div id="commentsAdd_submit">
                        <input type="submit" value="댓글등록">
                    </div>
                    <div id="commentsAdd_grade">
                        <select name="grade" id="123" class="fas fa-star" >
                        <option value="0"  disabled>-- 평 점 --</option>
                            <option value="1" class="fas fa-star">&#xf005</option>
                            <option value="2" class="fas fa-star">&#xf005 &#xf005</option>
                            <option value="3" class="fas fa-star">&#xf005 &#xf005 &#xf005</option>
                            <option value="4" class="fas fa-star">&#xf005 &#xf005 &#xf005 &#xf005</option>
                            <option value="5" class="fas fa-star">&#xf005 &#xf005 &#xf005 &#xf005 &#xf005</option>
                        </select>
                    </div>
                    <div id="commentsAdd_pw"> 
                        <input type="password" name="cpw" placeholder="비밀번호입력">
                        <input type="hidden" name="c_dcode" value="${dramaInfo.dcode }" >
                    </div>
                </form>
                </div>
  
                <div id="commentsList" style="overflow: scroll;">
                    <table style="width: 100%;">	
                    <c:forEach var = "comment" items="${ commentsList}">
                        <tr>
                            <td style="width: 20%; height: 40px; text-align: center;"><img src="File/Dramaview/${ comment.grade}.gif"  alt="${comment.grade }" style="width: 100px; height: 20px;"></td>
                            <td style="width: 20% ;text-align: center;">익명 : </td>
                            <td style="width: 60%;">${comment.comments }</td>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
                
            <div id="contents">
            <span>줄거리</span><br>
            ${dramaInfo.contents }
            </div>
            <div id="buyticket">
                <form action="TicketCheck" method="get" id="buyticket_form">
                <div id="buyticket_info">
                    <div id="buyticket_info1">
                        <p>영화이름 : ${dramaInfo.dname } </p>
                        <p>가격 :  ${dramaInfo.price } </p>                
                    </div>
                    <div id="buyticket_info2">
                        <p><label for="showdate">상영일 : </label>
                        <select name="showdate" id="showdate">
                            <option value="${dramaInfo.showdate }">${dramaInfo.showdate }</option>
                        </select></p>
                        <p><label for="tnumber">매수 : </label>
                        <select name="tnum" id="tnumber" >
							<option disabled>-- 최대 10매 --</option>
							<option value="1" >-- 1매 --</option>
							<option value="2" >-- 2매 --</option>
							<option value="3" >-- 3매 --</option>
							<option value="4" >-- 4매 --</option>
							<option value="5" >-- 5매 --</option>
							<option value="6" >-- 6매 --</option>
							<option value="7" >-- 7매 --</option>
							<option value="8" >-- 8매 --</option>
							<option value="9" >-- 9매 --</option>
							<option value="10" >-- 10매 --</option>
							
                        </select></p>
                   		
                   		<input type="hidden" name="dcode" value="${dramaInfo.dcode }" >
                   		<input type="hidden" name="mcode" value="${comment.c_mcode }" >
                   		
                    </div>
                </div>
                <div id="buyticket_btn"> 
                
                    <input type="button" value="예매하기" onclick="lastCheck()">
                    <input type="button" value="취소하기"  onclick="location.href ='Main.jsp'">
                </div>
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

function lastCheck() {
	if(${sessionScope.idCheck == null}){
		alert("로그인후 이용해 주세요.");
	} else{
			buyticket_form.submit();
	}
}

</script>
</html>