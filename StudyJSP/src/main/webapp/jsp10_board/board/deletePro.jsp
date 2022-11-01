<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
int idx = Integer.parseInt(request.getParameter("idx"));
String passwd = request.getParameter("passwd");

String driver="com.mysql.cj.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/study_jsp3";
String user="root";
String password="1234";

Class.forName(driver);
Connection con = DriverManager.getConnection(url, user, password);
// String sql = "DELETE FROM board WHERE idx=? AND passwd=?";
// PreparedStatement pstmt = con.prepareStatement(sql);
// pstmt.setInt(1, idx);
// pstmt.setString(2, passwd);

// int deleteCount = pstmt.executeUpdate();
// if(deleteCount > 0) {
	%>
	<script>
// 		alert("게시물 삭제 성공");
// 		location.href="list.jsp";
	</script>
	<%
// } else {
	%>
	<script>
// 		alert("게시물 삭제 실패!");
// 		history.back();
	</script>
	<%
// }
	String sql = "SELECT passwd FROM board WHERE idx=?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, idx);
	
	ResultSet rs = pstmt.executeQuery();
	
	if(rs.next()) {
		if(passwd.equals(rs.getString("passwd"))) {
			sql = "DELETE FROM board WHERE idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			int deleteCount = pstmt.executeUpdate();
			if(deleteCount > 0) {
				response.sendRedirect("list.jsp");
			} else {
	%>
				<script>
					alert("게시물 삭제 실패!");
					history.back();
				</script>
				<%
			}
		} else {
			%>
			<script>
				alert("패스워드 틀림!");
				history.back();
			</script>
			<%
		}
	} else {
	%>
		<script>
			alert("잘못된 접근입니다!");
			location.href="../index.jsp";
		</script>
	<%
	}
	%>