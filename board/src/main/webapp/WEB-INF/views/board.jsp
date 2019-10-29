<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-3.4.0.min.js"></script>
<jsp:include page="header.jsp" flush="true" />
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach var="row" items="${list}">
			<c:if test="${row.is_delete == 0}">
				<tr>
					<td>${row.bno}</td>
					<td><a href="${path}/board/view.do?bno=${row.bno}">${row.title}</a></td>
					<td>${row.wirter}</td>
					<td>
						<fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd"/>
					</td>	
					<td>${row.viewcnt}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>