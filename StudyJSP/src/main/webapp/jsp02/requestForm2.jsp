<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>requestForm2.jsp - 로그인 화면</h1>
	<form action="requestPro2.jsp" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" required="required">
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="passwd" required="required">
			</tr>
			<tr>
				<td colspan="2"><input type="submit" id = "sub" value="로그인"></td>
			</tr>
		</table>
	</form>
</body>
</html>