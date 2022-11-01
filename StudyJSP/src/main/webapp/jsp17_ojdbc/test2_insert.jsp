<%@page import="java.sql.ResultSet"%>
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
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.3.128:1521:orcl";
	String user = "hr";
	String password = "hr";
	
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, user, password);
	%>
	<h3>Oracle DB 연결 성공</h3>
	<hr>
	<%
	int idx = 1;
	String name = "seongmin";
	String sql = "INSERT INTO test_ojdbc VALUES (?,?)";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, idx);
	pstmt.setString(2, name);
	int count = pstmt.executeUpdate();
	pstmt.close();
	con.close();
	out.println("<h3>SQL 구문 실행 성공! - "+ count + "개 레코드</h3>");
	%>
</body>
</html>