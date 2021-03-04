<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="CSS//Memberview.css">
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
          <div id="view_header">
              <h1>회원정보 상세보기</h1>
          </div>
          <div id="view_body">
            <table>
              <tr>
                <td>이름</td>
                <td><p>${Modify.name }</p></td>
              </tr>
              <tr>
                <td>아이디</td>
                <td><p>${Modify.id }</p></td>
              </tr>
              <tr>
                <td>연락처</td>
                <td><p>${Modify.phone }</p></td>
              </tr>
              <tr>
                <td>등급</td>
                <td><p><img src="File/Grade/${Modify.rank }.gif" width="100px" height="100px"></p></td>
              </tr>
              <tr>
                <td>구매금액</td>
                <td><p>${Modify.buy }</p></td>
              </tr>
              <tr>
                <td>생년월일</td>
                <td><p>${Modify.birth }</p></td>
              </tr>
            </table>
          </div>
          <div id="view_foot">
              <input type="button" onclick="location.href='ModifyProcess'" value="수정하기">
              <input type="button" onclick="MemberDelete()" value="회원탈퇴">
          </div>



      </div>

</div>

</body>
<script type="text/javascript">
   function MemberDelete(){
      var pw = "${Modify.pw}";
      var checkpw = prompt("비밀번호>");
      if(pw == checkpw){
         location.href='MemberDelete';
      } else{
         alert("비밀번호가 틀립니다.")
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
</script>
</html>
