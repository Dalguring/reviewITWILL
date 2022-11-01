<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
// String studentNo = request.getParameter("studentNo");
// int studentNo =  (int)request.getParameter("studentNo");
int studentNo = Integer.parseInt(request.getParameter("studentNo"));
String name = request.getParameter("name");
String email = request.getParameter("email");
String phone = request.getParameter("phone");

String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/study_jsp3";
String user = "root";
String password = "1234";

Class.forName(driver);
Connection con = DriverManager.getConnection(url, user, password);
out.println("DB 연결 완료!");
String sql = "UPDATE student SET email=?, phone=? WHERE student_no=? AND name=?";
PreparedStatement pstnt = con.prepareStatement(sql);
pstnt.setString(1, email);
pstnt.setString(2, phone);
pstnt.setInt(3, studentNo);
pstnt.setString(4, name);
int count = pstnt.executeUpdate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 수정 정보 출력</h1>
	<h3>학번 : <%=studentNo %></h3>
	<h3>이름 : <%=name %></h3>
	<h3>E-Mail : <%=email %></h3>
	<h3>전화번호 : <%=phone %></h3>
	<hr>
	<h3>학생 정보 수정 완료 - <%=count %>개 레코드</h3>
</body>
</html>