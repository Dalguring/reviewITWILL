<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석 -->
	<h1>test.jsp</h1>
	<%--
	JSP주석입니다. 이 주석은 서버에서 처리되므로 웹 브라우저 소스보기를 통해 확인이 불가능합니다.
	=> JSP 코드가 포함될 경우 HTML 주석으로는 처리 불가능하므로 반드시 JSP 주석 사용해야함
	 --%>
	 <%
	 // 이 부분은 JAVA 코드가 기술되는 부분으로 웹 브라우저에서 코드가 표시되지 않습니다
	 //=> 서버에서 처리되는 코드입니다.
	 Timestamp now = new Timestamp(System.currentTimeMillis());
	 %>
	<!-- <h3>현재 시각 : <%=now %></h3> -->
</body>
</html>