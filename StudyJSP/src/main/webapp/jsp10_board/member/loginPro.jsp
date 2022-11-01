<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/study_jsp3";
String user = "root";
String password = "1234";

Class.forName(driver);
Connection con = DriverManager.getConnection(url, user, password);
String sql = "SELECT * FROM member WHERE id=? AND passwd=?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, id);
pstmt.setString(2, passwd);
ResultSet rs = pstmt.executeQuery();
if(rs.next()) {
		session.setAttribute("sId", id);
		// ==============================================================
		// 아이디 저장 관련 쿠키 기능 추가
		if(request.getParameter("rememberId") != null) {
			Cookie cookie = new Cookie("cookieId", id);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		}
		// ==============================================================
		
		response.sendRedirect("../index.jsp");
	} else {
		%>
			<script>
				alert("로그인 실패!");
				history.back();
			</script>
		<%
	}


%>