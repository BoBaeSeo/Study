<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
	<style>
		fieldset{width: 230px;}
		table, tr, td{border: 1px solid black; border-collapse: collapse;}
		.noBorder{border: 0px;}
	</style>
	<script>
	$(document).ready(function(){
		$("#userId").keyup(function(){
			var idCheck = $("#userId").val();
			if (idCheck.length > 0){
			$.ajax({
				type : "get",
				url : "checkId",
				data : {"uId" : idCheck },
				success : function(data) {
					console.log("data:" + data);
					if(data == "OK"){
						$("#confirmId").css("color", "green").text("사용가능")
					} else {
						$("#confirmId").css("color", "red").text("사용 불가능")
					}
				},
				error : function(){
					// 전송 실패 할 경우 실행되는 부분
					console.log("노전송");
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
	<h2>JoinForm.jsp</h2>
	<fieldset>
		<button onclick="main()">메인으로</button>
		<button onclick="memberLogin()">로그인</button>
		<button onclick="location.href='/MemberBoard/board/boardList'">글목록조회</button>
	</fieldset>
	<h2>회원가입</h2>
	<form action="memberJoin" method="post">
		<table>
			<tr><td>아이디</td><td><input type="text" name="userId" placeholder="4~10자리" id="userId"><br><span id="confirmId"></span></td></tr>
			<tr><td>비밀번호</td><td><input type="text" name="userPw" placeholder="8~16자리" id="userPw"></td></tr>
			<tr><td>이름</td><td><input type="text" id="name" name="userName"></td></tr>
			<tr><td>생년월일</td><td><input type="date" id="brith" name="userBirth" required></td></tr>
			<tr><td>성별</td><td><label><input type="radio" name="userGender" value="남">남자</label><label><input type="radio" name="userGender" value="여">여자</label></td></tr>
			<tr><td>이메일</td><td><input type="text" name="userEmail" id="email">@<select name="email" id="emailSel">
                <option value="">직접입력</option>
                <option value="naver.com">naver.com</option>
                <option value="daum.net">daum.net</option>
                <option value="gmail.com">gmail.com</option>
            </select></td></tr>
			<tr><td colspan="2"><input type="submit" value="회원가입"> <input type="reset" value="다시작성"></td></tr>
		</table>
	</form>
</body>
<script>
	function main(){
		location.href="/MemberBoard/Main.jsp";
	}		
	function memberLogin(){
		location.href="MemberBoard/member/LoginForm.jsp";
	}
</script>
</html>