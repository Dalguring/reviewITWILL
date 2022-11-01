<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>attributeTest1.jsp</h1>
	<%
	pageContext.setAttribute("pageContextValue", "pageContext value");
	request.setAttribute("requestValue", "request value");
	session.setAttribute("sessionValue", "session value");
	application.setAttribute("applicationValue", "application value");
	%>
	
	<h3>pageContext 객체 값 : <%=pageContext.getAttribute("pageContextValue") %></h3>
	<h3>request 객체 값 	: <%=request.getAttribute("requestValue") %></h3>
	<h3>session 객체 값 	: <%=session.getAttribute("sessionValue") %></h3>
	<h3>application 객체 값 : <%=application.getAttribute("applicationValue") %></h3>
	
	<%
	pageContext.forward("attributeTest2.jsp");
	
	%>
</body>
</html>