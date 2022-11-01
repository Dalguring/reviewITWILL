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
	<h1>글 목록</h1>
	<table border="1">
		<tr>
			<th width="50">번호</th>
			<th width="400">제목</th>
			<th width="150">작성자</th>
			<th width="150">작성일</th>
			<th width="100">조회수</th>
		</tr>
		<%
		request.setCharacterEncoding("UTF-8");
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/study_jsp3";
		String user="root";
		String password="1234";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "SELECT * FROM board ORDER BY idx DESC";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) { 
			int idx = rs.getInt(1);
			String subject = rs.getString(4);
			String name = rs.getString(2);
			int readcount = rs.getInt(7); 
		%>
			<tr>
				<td><%=idx %></td>
				<td><a href="content.jsp?idx=<%=idx %>"><%=subject %></a></td>
				<td><%=name %></td>
				<td><%=rs.getDate("date") %></td>
				<td><%=readcount %></td>
			</tr>
		<%	
		}
		%>
	</table>
	<div align="right"><input type="button" value="글쓰기" onclick="location.href='writeForm.jsp'">
	
	</div>
</body>
</html>