<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>sessionTest2_invalidate.jsp</h1>
	<%
	session.invalidate();
	response.sendRedirect("sessionTest2_get.jsp");
	%>
</body>
</html>