<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script src="http://code.jquery.com/jquery-3.4.0.min.js"></script>

	<a href="/board/list.do">홈</a>
	<c:choose>
		<c:when test="${sessionScope.user_id == null}">
			<a href="/member/login.do">로그인</a>
			<a href="/member/insertview.do">회원가입</a>
		</c:when>
		<c:otherwise>
			${sessionScope.user_name}님이 로그인중입니다.
			<a href="/member/logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>
