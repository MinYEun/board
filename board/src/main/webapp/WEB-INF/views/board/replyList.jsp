<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="width:700px">
        <c:forEach var="row" items="${list}">
        <tr>    
            <td>
                ${row.user_name}(<fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>)
                <br>
                ${row.replytext}
            </td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>