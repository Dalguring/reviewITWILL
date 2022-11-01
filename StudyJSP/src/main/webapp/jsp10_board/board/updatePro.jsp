<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
int idx = Integer.parseInt(request.getParameter("idx"));
// String name = request.getParameter("name");
String passwd = request.getParameter("passwd");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

// out.println(idx + ", " + name + ", " + passwd + ", " + subject + ", " + content);
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/study_jsp3";
String user = "root";
String password = "1234";
Class.forName(driver);
Connection con = DriverManager.getConnection(url, user, password);

String sql = "UPDATE board SET subject=?, content=? WHERE idx=? AND passwd=?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, subject);
pstmt.setString(2, content);
pstmt.setInt(3, idx);
pstmt.setString(4, passwd);

int updateCount = pstmt.executeUpdate();
if(updateCount > 0) {
	response.sendRedirect("content.jsp?idx=" + idx);
} else {
	%>
		<script>
			alert("글 수정 실패!");
			history.back();
		</script>
	<%
}
%>