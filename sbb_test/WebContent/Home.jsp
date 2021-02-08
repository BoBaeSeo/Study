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
            height: 200px;
        }
    </style>
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

            </div>
            Some text..
        </div>
        <div class="footer">
            <h2>인천일보 아카데미</h2>
        </div>
    </div>
</body>
</html>