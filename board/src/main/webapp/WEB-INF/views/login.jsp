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
            // ��ũ.val() : �±׿� �Էµ� ��
            // ��ũ.val("��") : �±��� ���� ���� 
            var userId = $("#user_id").val();
            var userPw = $("#password").val();
            if(userId == ""){
                alert("���̵� �Է��ϼ���.");
                $("#user_id").focus(); // �Է���Ŀ�� �̵�
                return; // �Լ� ����
            }
            if(userPw == ""){
                alert("���̵� �Է��ϼ���.");
                $("#password").focus();
                return;
            }
            // �� ������ �����͸� ������ �ּ�
            document.form1.action="/member/loginCheck.do"
            // ����
            document.form1.submit();
        });
    });
</script> -->
</head>
<body>
	<h2>�α���</h2>
	<form name="login" method="post" action="/member/loginCheck.do">
		<div class="content">
			<div>
				<p>���̵�</p>
				<input type="text" id="user_id" name="user_id"/>
				<p>��й�ȣ</p>
				<input type="password" id="password" name="password" />
				
				<button type="submit" id="btnLogin">�α���</button>
			</div>
		</div>
	</form>
</body>
</html>