<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
	<h1>jdbc_connect_test3.jsp</h1>
	<%
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/study_jsp3";
	String user="root";
	String password="1234";
	//1단계
	Class.forName(driver);
	//2단계
	Connection con = DriverManager.getConnection(url, user, password);
	%>
	
	<h3>1단계&2단계 성공</h3>
	<h3>Connection 객체 정보 : <%=con %></h3>
	
	<% //3단계
// 	String sql = "CREATE TABLE test(idx INT)";
	String sql = "CREATE TABLE test2(idx INT, name VARCHAR(10))";
// 	String sql = "DROP TABLE test";
// 	String sql = "INSERT INTO test VALUES (2)";
// 	String sql = "DELETE FROM test";
	PreparedStatement pstnt = con.prepareStatement(sql);
	%>
	<h3>SQL 구문 전달 완료</h3>
	<% //4단계
	int count = pstnt.executeUpdate();
	%>
	<h3>SQL 구문 실행 완료! - <%=count %></h3>
</body>
</html>