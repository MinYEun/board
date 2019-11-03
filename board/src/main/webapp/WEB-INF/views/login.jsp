<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	$(document).ready(function(){
		$("#btnLogin").unbind("click").click(function(e) {
			e.preventDefault();
			fn_login();
		});
	});
	
	function fn_login(){
		if($("#user_id").val().length < 1){
			alert("아이디를 입력해주세요");
		} else if($("#password").val().length < 1) {
			alert("비밀번호를 입력해주세요");
		} else {
			login.setUrl("<c:url value='/member/loginCheck.do' />");
			login.submit();
		}
	}
</script>
</head>
<jsp:include page="board/header.jsp" flush="true" />
<body>
	<h2>로그인</h2>
	<form id="login" name="login" method="post" action="/member/loginCheck.do">
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