<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String passwd = request.getParameter("passwd");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

String driver="com.mysql.cj.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/study_jsp3";
String user="root";
String password="1234";

Class.forName(driver);
Connection con = DriverManager.getConnection(url, user, password);

int idx = 1;
String sql = "SELECT MAX(idx) FROM board";
PreparedStatement pstmt = con.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();

if(rs.next()) {
	idx = rs.getInt(1) + 1;
}

//-------------------------------------------------------------------------------------------
sql = "INSERT INTO board VALUES (?,?,?,?,?,now(),0)";
pstmt = con.prepareStatement(sql);
pstmt.setInt(1, idx);
pstmt.setString(2, name);
pstmt.setString(3, passwd);
pstmt.setString(4, subject);
pstmt.setString(5, content);

int insertCount = pstmt.executeUpdate();
if(insertCount > 0) {
	response.sendRedirect("list.jsp");
} else {%>
	<script>
		alert("글쓰기실패!");
		history.back();
	</script>
<%	
}
%>