<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" flush="true" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
$(document).ready(function(){

    // ** 댓글 쓰기 버튼 클릭 이벤트 (ajax로 처리)
    $("#btnReply").click(function(){
        var replytext=$("#replytext").val();
        var bno="${view.bno}"
        var param="replytext="+replytext+"&bno="+bno;
        $.ajax({                
            type: "post",
            url: "/reply/insert.do",
            data: param,
            success: function(){
                alert("댓글이 등록되었습니다.");
                listReply2();
            }
        });
    });
	function listReply2(){
	    $.ajax({
	        type: "get",
	        //contentType: "application/json", ==> 생략가능(RestController이기때문에 가능)
	        url: "/reply/listJson.do?bno=${view.bno}",
	        success: function(result){
	            console.log(result);
	            var output = "<table>";
	            for(var i in result){
	                output += "<tr>";
	                output += "<td>"+result[i].userName;
	                output += "("+changeDate(result[i].regdate)+")<br>";
	                output += result[i].replytext+"</td>";
	                output += "<tr>";
	            }
	            output += "</table>";
	            $("#listReply").html(output);
	        }
	    });
	}
}

//수정
 function fn_update(){
     
     var form = document.getElementById("view");
     
     form.action = "<c:url value='/board/update.do'/>";
     form.submit();
 }
 </script>
</head>
<body>
<form id="view" name="view" method="post">
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
        <input name="writer" id="writer" value="${view.writer}" placeholder="이름을 입력해주세요" readOnly>
    </div>
    <div style="width:650px; text-align: center;">
        <!-- 게시물번호를 hidden으로 처리 -->
        <input type="hidden" name="bno" value="${view.bno}">
    </div>
</form>
        <c:if test="${sessionScope.user_id eq view.writer}">
        	<a href="#" onclick="fn_update()">수정</a>
        	<a href="/board/delete.do?bno=${view.bno}">삭제</a>
        </c:if>
 <div style="width:650px; text-align: center;">
        <br>
        <!-- **로그인 한 회원에게만 댓글 작성폼이 보이게 처리 -->
        <c:if test="${sessionScope.user_id != null}">    
        <textarea rows="5" cols="80" id="replytext" placeholder="댓글을 작성해주세요"></textarea>
        <br>
        <button type="button" id="btnReply">댓글 작성</button>
        </c:if>
    </div>
    <!-- **댓글 목록 출력할 위치 -->
    <div id="listReply"></div>
</body>
</html>