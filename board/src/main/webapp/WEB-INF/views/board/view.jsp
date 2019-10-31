<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
    $(document).ready(function(){
        $("#btnDelete").click(function(){
            if(confirm("�����Ͻðڽ��ϱ�?")){
                document.view.action = "/board/delete.do";
                document.view.submit();
            });
       });
</script>
</head>
<body>
<jsp:include page="header.jsp" flush="true" />
<form id="view" name="view" method="get">
    <div>        <!-- ���ϴ� ��¥�������� ����ϱ� ���� fmt�±� ��� -->
        �ۼ����� : <fmt:formatDate value="${view.regdate}" pattern="yyyy-MM-dd"/>
                <!-- ��¥ ���� => yyyy 4�ڸ�����, MM ��, dd ��, a ����/����, HH 24�ð���, hh 12�ð���, mm ��, ss �� -->
    </div>
    <div>
        ��ȸ�� : ${view.viewcnt}
    </div>
    <div>
        ����
        <input name="title" id="title" size="80" value="${view.title}" placeholder="������ �Է����ּ���">
    </div>
    <div>
        ����
        <textarea name="content" id="content" rows="4" cols="80" placeholder="������ �Է����ּ���">${view.content}</textarea>
    </div>
    <div>
        �̸�
        <input name="writer" id="writer" value="${view.writer}" placeholder="�̸��� �Է����ּ���">
    </div>
    <div style="width:650px; text-align: center;">
        <!-- �Խù���ȣ�� hidden���� ó�� -->
        <input type="hidden" name="bno" value="${view.bno}">
        <c:if test="${member.user_id eq boardVO.writer}">
        	<button type="button" id="btnUpdete">����</button>
        	<button type="button" id="btnDelete">����</button>
        </c:if>
    </div>
</form>
</body>
</html>