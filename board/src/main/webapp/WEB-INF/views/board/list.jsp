<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="header.jsp" flush="true" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"/>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script>
$(document).ready( function () {
    $('#table').DataTable({
    	ordering: false,
    	lengthChange: false,
    	filter: false,
    	paging: true
    });
} );
</script>
</head>

<body>
	<table border="1" id="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="row" items="${list}">
				<tr>
					<td>${row.bno}</td>
					<td>
						<a href="${path}/board/view.do?bno=${row.bno}">${row.title}</a>
						<c:if test="${row.recnt>0}">
							<span>(${row.recnt})</span>
						</c:if>
					</td>
					<td>${row.writer}</td>
					<td>
						<fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd"/>
					</td>	
					<td>${row.viewcnt}</td>
				</tr>
		</c:forEach>
	</tbody>	
	</table>
	<a href="/board/write.do">글쓰기</a>
</body>
</html>