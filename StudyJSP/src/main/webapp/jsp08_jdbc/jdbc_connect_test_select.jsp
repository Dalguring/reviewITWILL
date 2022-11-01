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
	<h1>jdbc_connect_test_select.jsp</h1>
	<%
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/study_jsp3";
	String user="root";
	String password="1234";

	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, user, password);
	out.println("<h3>1단계,2단계 성공</h3>");
	//3단계
	String sql = "SELECT * FROM test2";
	PreparedStatement pstnt = con.prepareStatement(sql);
	//4단계
	ResultSet rs = pstnt.executeQuery();
// 	out.println(rs.next());
// 	out.println(rs.next());
// 	out.println(rs.next());
// 	out.println(rs.next());
// 	out.println(rs.next());
// 	if(rs.next()) {
// 		out.println("레코드 존재함!");
// 	} else {
// 		out.println("레코드 존재하지않음!");
// 	}
	while(rs.next()) {
// 		out.println("레코드 존재함!");
// 		int idx = rs.getInt(1);
// 		out.println(idx + "<br>");
		int idx = rs.getInt("idx");
		String name = rs.getString("name");
		out.println(idx + ", " + name + "<br>");
	}
	%>
	
</body>
</html>