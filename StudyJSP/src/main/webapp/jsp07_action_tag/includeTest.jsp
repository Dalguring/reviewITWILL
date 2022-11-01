<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>incluteTest.jsp</h1>
	<jsp:include page = "includeTest2.jsp">
		<jsp:param name="paramValue" value="Parameter Value" />
	
	</jsp:include>
</body>
</html>