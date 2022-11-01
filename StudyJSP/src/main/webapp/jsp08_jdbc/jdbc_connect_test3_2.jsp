<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp3", "root", "1234");
	
// 	int num = 10;
// 	String sql = "INSERT INTO test VALUES (?)";
// 	PreparedStatement pstnt = con.prepareStatement(sql);
// 	pstnt.setInt(1, num);
	int num = 3;
	String name = "서성민";
// 	String sql = "INSERT INTO test2 VALUES ("+ num + ",'" + name + "')";
	String sql = "CREATE TABLE student (student_no INT PRIMARY KEY, name VARCHAR(16) NOT NULL, email VARCHAR(50) UNIQUE NOT NULL, phone VARCHAR(20) UNIQUE NOT NULL)";
	PreparedStatement pstnt = con.prepareStatement(sql);
// 	pstnt.setInt(1, num);
// 	pstnt.setString(2, name);
	int count = pstnt.executeUpdate();
	%>
	<h3>SQL 구문 실행 완료! - <%=count %></h3>
</body>
</html>