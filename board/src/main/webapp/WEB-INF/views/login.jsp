<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- <script>
    $(document).ready(function(){
        $("#btnLogin").click(function(){
            // 태크.val() : 태그에 입력된 값
            // 태크.val("값") : 태그의 값을 변경 
            var userId = $("#user_id").val();
            var userPw = $("#password").val();
            if(userId == ""){
                alert("아이디를 입력하세요.");
                $("#user_id").focus(); // 입력포커스 이동
                return; // 함수 종료
            }
            if(userPw == ""){
                alert("아이디를 입력하세요.");
                $("#password").focus();
                return;
            }
            // 폼 내부의 데이터를 전송할 주소
            document.form1.action="/member/loginCheck.do"
            // 제출
            document.form1.submit();
        });
    });
</script> -->
</head>
<body>
	<h2>로그인</h2>
	<form name="login" method="post" action="/member/loginCheck.do">
		<div class="content">
			<div>
				<p>아이디</p>
				<input type="text" id="user_id" name="user_id"/>
				<p>비밀번호</p>
				<input type="password" id="password" name="password" />
				
				<button type="submit" id="btnLogin">로그인</button>
			</div>
		</div>
	</form>
</body>
</html>