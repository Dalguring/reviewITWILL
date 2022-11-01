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
	
	String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, Integer.parseInt(request.getParameter("EMPLOYEE_ID")));
	ResultSet rs = pstmt.executeQuery();
	out.println("<table border='1'>");
	out.println("<tr><th>EMPLOYEE_ID</th><th>FIRST_NAME</th><th>LAST_NAME</th><th>EMAIL</th><th>PHONE_NUMBER</th><th>HIRE_DATE</th><th>JOB_ID</th><th>SALARY</th><th>COMMISSION_PCT</th><th>MANAGER_ID</th><th>DEPARTMENT_ID</th></tr>");
	if(rs.next()) {
		out.println("<tr>");
			out.println("<td>" + rs.getInt(1) + "</td>");
			out.println("<td>" + rs.getString(2) + "</td>");
			out.println("<td>" + rs.getString(3) + "</td>");
			out.println("<td>" + rs.getString(4) + "</td>");
			out.println("<td>" + rs.getString(5) + "</td>");
			out.println("<td>" + rs.getDate(6) + "</td>");
			out.println("<td>" + rs.getString(7) + "</td>");
			out.println("<td>" + rs.getDouble(8) + "</td>");
			out.println("<td>" + rs.getDouble(9) + "</td>");
			out.println("<td>" + rs.getInt(10) + "</td>");
			out.println("<td>" + rs.getInt(11) + "</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	out.println("<input type='button' value='back' onclick='history.back()'");
	rs.close();
	pstmt.close();
	con.close();
	%>
</body>
</html>