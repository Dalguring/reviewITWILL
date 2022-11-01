<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>sessionTest2_get.jsp</h1>
	<h3>세션에 저장된 값 : <%=session.getAttribute("sessionValue1") %></h3>
	<h3>세션에 저장된 값 : <%=session.getAttribute("sessionValue2") %></h3>
	<hr>
	<h3><a href = "sessionTest2_set.jsp">돌아가기</a></h3>
</body>
</html>