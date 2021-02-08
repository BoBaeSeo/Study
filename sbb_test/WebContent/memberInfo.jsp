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
        function modifyCheck() {
            var userId = $("#userId").val();
            var userPw = $("#userPw").val();
            var userName = $("#userName").val();
            var userPhone = $("#userPhone").val();
            var gender = $("input[name='gender']:checked").val();
            var addr = $("#addr").val();
            var email = $("#inputEmail").val() + "@" + $("#emailDomain").val();
            if(userId == ""){
                alert('아이디를 입력해주세요.')
                $("#userId").focus()
                return
            }
            if(userPw == ""){
                alert('비밀번호를 입력해주세요.')
                $("#userPw").focus()
                return
            }
            if(userName == ""){
                alert('이름을 입력해주세요.')
                $("#userName").focus()
                return
            }
            if(userPhone == ""){
                alert('전화번호를 입력해주세요.')
                $("#userPhone").focus()
                return
            }
            if(gender != null && addr != "" && email != "@"){
            	if("${memberDTO.userpw }" != userPw){
            		alert('비밀번호가 일치하지 않습니다.')
            		$("#userPw").focus();
            		return;
            	}
                var result = '아이디: '+userId+'\n비밀번호: '+userPw+'\n이름: '+userName+'\n전화번호: '+userPhone+'\n성별: '+gender+'\n주소: '+addr+'\n이메일: '+email;
                alert(result);
                modifyForm.submit();
                
            } else {
                alert('작성을 완료해주세요.')
            }
        }
        $(function(){
            $("#email").change(function(){
                $("#emailDomain").val($("#email").val())
            })
        })
        $(document).ready(function() {
        	var gender = "${memberDTO.usergender}";
        	var man = $("#man").val();
        	var woman = $("#woman").val();
        	if(gender == man) $("#man").prop('checked', true);
        	if(gender == woman) $("#woman").prop('checked', true);
        })
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
                <form action="memberModify" id="modifyForm" method="post">
                <table style="margin-left: auto;margin-right: auto;background-color: snow;">
                    <tr>
                        <td colspan="2">회원가입</td>
                        <td style="display: none"> <input type="hidden" name="userNum" value="${memberDTO.usernum }"></td>
                    </tr>
                    <tr>
                        <td>아이디</td>
                        <td><input type="text" id="userId" name="userId" readonly="readonly" value="${memberDTO.userid }"></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input type="text" id="userPw" name="userPw" value="${memberDTO.userpw }"></td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td><input type="text" id="userName" name="userName" value="${memberDTO.username }"></td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td><input type="text" id="userPhone" name="userPhone" value="${memberDTO.userphone }"></td>
                    </tr>
                    <tr>
                        <td>성별</td>
                        <td><label for="man">남자</label><input type="radio" id="man" name="gender" value="남">
                            <label for="woman">여자</label><input type="radio" id="woman" name="gender" value="여"></td>
                    </tr>
                    <tr>
                        <td>주소</td>
                        <td><input type="text" id="addr" name="addr" value="${memberDTO.useraddr }"></td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td><input type="text" id="inputEmail" name="inputEmail" value="${memberDTO.inputEmail }"> @ <input type="text" id="emailDomain" name="emailDomain" value="${memberDTO.emailDomain }"> 
                            <select id="email">
                                <option value="">직접입력</option>
                                <option>naver.com</option>
                                <option>google.com</option>
                                <option>daum.net</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td colspan="2"><button type="button" onclick="modifyCheck()">수정</button> <button type="reset">취소</button></td>
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