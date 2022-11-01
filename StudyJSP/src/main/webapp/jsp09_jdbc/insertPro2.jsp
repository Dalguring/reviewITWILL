<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
// String studentNo = request.getParameter("studentNo");
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
String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";
PreparedStatement pstnt = con.prepareStatement(sql);
pstnt.setInt(1, studentNo);
pstnt.setString(2, name);
pstnt.setString(3, email);
pstnt.setString(4, phone);
int count = pstnt.executeUpdate();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 정보 출력</h1>
	<h3>학번 : <%=studentNo %></h3>
	<h3>이름 : <%=name %></h3>
	<h3>E-Mail : <%=email %></h3>
	<h3>전화번호 : <%=phone %></h3>
	<hr>
	<h3>학생 정보 DB 저장 완료 - <%=count %>개 레코드</h3>
</body>
</html>