<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form name="form1" method="post" action="${path}/member/insert.do">
		<table border="1" width="400px">
			<tr>
				<td>���̵�</td>
				<td><input name="user_id" type="text"></td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="user_name"></td>
			</tr>
			<tr>
				<td>�̸���</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Ȯ��">
					<input type="reset" value="���">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>