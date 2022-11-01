<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int studentNo = Integer.parseInt(request.getParameter("studentNo"));

request.setCharacterEncoding("UTF-8");
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/study_jsp3";
String user = "root";
String password = "1234";

Class.forName(driver);
Connection con = DriverManager.getConnection(url, user, password);
String sql = "SELECT * FROM student WHERE student_no=?";
PreparedStatement pstnt = con.prepareStatement(sql);
pstnt.setInt(1, studentNo);
ResultSet rs = pstnt.executeQuery();

// String name = "";
// String email = "";
// String phone = "";

// if(rs.next()) {
// 	name = rs.getString("name");
// 	email = rs.getString("email");
// 	phone = rs.getString("phone");
// }
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 상세 정보 조회</h1>
<%-- 	<h3>학번 : <%=studentNo %></h3> --%>
<%-- 	<h3>이름 : <%=name %></h3> --%>
<%-- 	<h3>E-Mail : <%=email %></h3> --%>
<%-- 	<h3>전화번호 : <%=phone %></h3> --%>

	<%
	if(rs.next()) {
		String name = rs.getString("name");
		String email = rs.getString("email");
		String phone = rs.getString("phone");
		%>
		<h3>학번 : <%=studentNo %></h3>
		<h3>이름 : <%=name %></h3>
		<h3>E-Mail : <%=email %></h3>
		<h3>전화번호 : <%=phone %></h3>
		
		<%
	}
	
	%>
</body>
</html>