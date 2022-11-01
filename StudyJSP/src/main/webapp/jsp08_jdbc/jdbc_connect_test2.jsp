<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jdbc_connect_test2.jsp</h1>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	%>
	<h3>드라이버 로드 성공</h3>
	
	<%
	DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp3", "root", "1234");
	%>
	<h3>DB 연결 성공</h3>
</body>
</html>