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
	out.println("<h3>Oracle DB 연결 성공</h3>");
	
	String sql = "SELECT * FROM test_ojdbc";
	PreparedStatement pstmt = con.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	
	out.println("<h3>test_ojdbc 테이블 조회 성공</h3>");
	while(rs.next()) {
		out.println("idx : " + rs.getInt(1));
		out.println("name : " + rs.getString(2) + "<br>");
	}
	rs.close();
	pstmt.close();
	con.close();
	%>
</body>
</html>