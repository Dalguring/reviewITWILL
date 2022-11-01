<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// response.sendRedirect("pageContextTest2.jsp");

pageContext.forward("pageContextTest2.jsp");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>pageContextTest1.jsp</h1>
	<script type="text/javascript">
	alert("확인");
	</script>
</body>
</html>