<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/study_jsp3";
String user = "root";
String password = "1234";

Class.forName(driver);
Connection con = DriverManager.getConnection(url, user, password);
String sql = "SELECT * FROM student";
PreparedStatement pstnt = con.prepareStatement(sql);
ResultSet rs = pstnt.executeQuery();
// while(rs.next()) {
// 	int student_no = rs.getInt(1);
// 	String name = rs.getString(2);
// 	String email = rs.getString(3);
// 	String phone = rs.getString(4);
// }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 목록 조회</h1>
	<table border="1">
		<tr>
			<th width="100">학번</th>
			<th width="150">이름</th>
			<th width="250">E-Mail</th>
			<th width="200">전화번호</th>
			<th width="100"></th>
		</tr>
		<%
		while(rs.next()) {
			int studentNo = rs.getInt(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			String phone = rs.getString(4);
			
// 		out.println("<tr>");
// 		out.println("<td>" + studentNo + "</td>");
// 		out.println("<td>" + name + "</td>");
// 		out.println("<td>" + email + "</td>");
// 		out.println("<td>" + phone + "</td>");
// 		out.println("</tr>");	
		%>	
		<tr>
			<td><%=studentNo %></td>
			<td><%=name %></td>
			<td><%=email %></td>
			<td><%=phone %></td>
			<td><input type="button" value="상세정보" onclick="location.href='select_student_info.jsp?studentNo=<%=studentNo%>'"></td>
		</tr>
		<%
		}
		%>	
	</table>
</body>
</html>