<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script>
    $(document).ready(function(){
        $("#btnSave").click(function(){
            //var title = document.form1.title.value; ==> name�Ӽ����� ó���� ���
            //var content = document.form1.content.value;
            //var writer = document.form1.writer.value;
            var title = $("#title").val();
            var content = $("#content").val();
            var writer = $("#writer").val();
            if(title == ""){
                alert("������ �Է��ϼ���");
                document.form1.title.focus();
                return;
            }
            if(content == ""){
                alert("������ �Է��ϼ���");
                document.form1.content.focus();
                return;
            }
            if(writer == ""){
                alert("�̸��� �Է��ϼ���");
                document.form1.writer.focus();
                return;
            }
            // ���� �Է��� �����͸� ������ ����
            document.write.submit();
        });
    });
</script>
</head>
<body>
<jsp:include page="header.jsp" flush="true" />
<h2>�Խñ� �ۼ�</h2>
<form name="write" method="post" action="/board/insert.do">
    <div>
        ����
        <input name="title" id="title" size="80" placeholder="������ �Է����ּ���">
    </div>
    <div>
        ����
        <textarea name="content" id="content" rows="4" cols="80" placeholder="������ �Է����ּ���"></textarea>
    </div>
    <div>
        �̸�
        <input name="writer" id="writer" value="{list.writer}">
    </div>
    <div style="width:650px; text-align: center;">
        <button type="button" id="btnSave">Ȯ��</button>
        <button type="button" onclick="location.href='/board/list.do'">���</button>
    </div>
</form>
</body>
</html>