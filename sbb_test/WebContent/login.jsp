<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
    <style>
        div{
            padding: 20px;
        }
        .container{
            background-color: burlywood;
            width: auto;
            height: auto;
        }
        .header{
            background-color: cadetblue;
            height: 150px;
            text-align: center;
        }
        .bar{
            background-color: black;
            height: 50px;
        }
        .content{
            background-color: white;
            margin-top: 20px;
            height: auto;
        }
        .footer{
            background-color: tomato;
            margin-top: 20px;
            height: 80px;
            text-align: center;
        }
        h1{
            font-size: 45px;
            padding: 5px;
        }
        h3{
            padding: 7px;
        }
        a{
            color: snow;
            text-decoration: none;
            font-size: 25px;
            padding: 5px;
        }
        .barLeft{
            float: left;
        }
        .barRight{
            float: right;
        }
        .contentBody{
            background-color: yellowgreen;
            height: auto;
            margin: auto;
        }
        table, tr, td{
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
            padding: 20px;
        }
    </style>
    <script>
        $(function(){
            $("#userId").keyup(function(){
                var userId = $("#userId").val();
                if(userId.length < 4 || userId.length > 8){
                    $("#userIdCheck").text("아이디는 4~8자 사이여야 합니다.").css("color", "red");
                } else {
                    $("#userIdCheck").text("사용가능합니다.").css("color", "green");
                }
            })
            $("#userPw").keyup(function(){
                var userPw = $("#userPw").val();
                if(userPw.length < 4 || userPw.length > 8){
                    $("#userPwCheck").text("패스워드는 4~8자 사이여야 합니다.").css("color", "red");
                } else {
                    $("#userPwCheck").text("사용가능합니다.").css("color", "green");
                }
            })
        })

        function idPwCheck() {
            var userId = $("#userId").val();
            var userPw = $("#userPw").val();
            if(userId == ""){
                alert('아이디를 입력해주세요.')
                $("#userId").focus()
                return
            }
            else if(userPw == ""){
                alert('비밀번호를 입력해주세요.')
                $("#userPw").focus()
                return
            } else {
	            loginForm.submit();
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Java기반 Back-End개발자 & 정보처리산업기사</h1>
        </div>
        <div class="bar">
            <a href="./Home.jsp" class="barLeft">홈으로</a>
            <c:choose>
            	<c:when test="${sessionScope.loginId == null }">
            		<a href="./join.jsp" class="barRight">회원가입</a>
            		<a href="./login.jsp" class="barRight">로그인</a>
            	</c:when>
            	<c:otherwise>
            		<a href="logout" class="barRight">로그아웃</a>
            		<a href="memberInfo" class="barRight">내정보</a>
            	</c:otherwise>
            </c:choose>
        </div>
        <div class="content">
            <h2>컨텐츠 화면</h2>
            <p>Java기반 Back-End개발자 & 정보처리산업기사</p>
            <div class="contentBody">
            <form action="memberLogin" id="loginForm" method="post">
                <table style="margin-left: auto;margin-right: auto;background-color: snow;">
                    <tr>
                        <td colspan="2">로그인</td>
                    </tr>
                    <tr>
                        <td>아이디</td>
                        <td><input type="text" id="userId" name="userId"><br><span id="userIdCheck"></span></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input type="text" id="userPw" name="userPw"><br><span id="userPwCheck"></span></td>
                    </tr>
                    <tr>
                        <td colspan="2"><button type="button" onclick="idPwCheck()">로그인</button></td>
                    </tr>
                </table>
               </form>
            </div>
        </div>
        <div class="footer">
            <h2>인천일보 아카데미</h2>
        </div>
    </div>
</body>
</html>