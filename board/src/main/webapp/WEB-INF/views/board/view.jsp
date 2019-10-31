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
            if(confirm("삭제하시겠습니까?")){
                document.view.action = "/board/delete.do";
                document.view.submit();
            });
       });
</script>
</head>
<body>
<jsp:include page="header.jsp" flush="true" />
<form id="view" name="view" method="get">
    <div>        <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
        작성일자 : <fmt:formatDate value="${view.regdate}" pattern="yyyy-MM-dd"/>
                <!-- 날짜 형식 => yyyy 4자리연도, MM 월, dd 일, a 오전/오후, HH 24시간제, hh 12시간제, mm 분, ss 초 -->
    </div>
    <div>
        조회수 : ${view.viewcnt}
    </div>
    <div>
        제목
        <input name="title" id="title" size="80" value="${view.title}" placeholder="제목을 입력해주세요">
    </div>
    <div>
        내용
        <textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요">${view.content}</textarea>
    </div>
    <div>
        이름
        <input name="writer" id="writer" value="${view.writer}" placeholder="이름을 입력해주세요">
    </div>
    <div style="width:650px; text-align: center;">
        <!-- 게시물번호를 hidden으로 처리 -->
        <input type="hidden" name="bno" value="${view.bno}">
        <c:if test="${member.user_id eq boardVO.writer}">
        	<button type="button" id="btnUpdete">수정</button>
        	<button type="button" id="btnDelete">삭제</button>
        </c:if>
    </div>
</form>
</body>
</html>