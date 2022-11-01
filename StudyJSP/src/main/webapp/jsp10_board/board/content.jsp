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
	if(request.getParameter("idx") == null) {%>
	<script>
		alert("잘못된 접근입니다!");
		location.href="../index.jsp";
	</script>	
	<% 
	}
	%>
	<h1>글 상세내용 보기</h1>
	<%
	int idx = Integer.parseInt(request.getParameter("idx"));
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
	//조회수 증가 작업
	String sql = "UPDATE board SET readcount=readcount+1 WHERE idx=?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, idx);
	pstmt.executeUpdate();
	
	sql = "SELECT * FROM board WHERE idx=?";
	pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, idx);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) { 
		%>
		<table border="1">
			<tr>
				<th width="100">글번호</th><td width="100"><%=idx %></td>
				<th width="100">작성자</th><td width="100"><%=rs.getString("name") %></td>
				<th width="100">작성일</th><td width="100"><%=rs.getDate("date") %></td>
			</tr>
			<tr>
				<th>제목</th><td colspan="3"><%=rs.getString("subject") %></td>
				<th>조회수</th><td colspan="3"><%=rs.getInt("readcount") %></td>
			</tr>
			<tr>
				<th>내용</th><td colspan="5"><%=rs.getString("content") %></td>
			</tr>
			<tr>
				<td colspan="6" align="right">
					<input type="button" value="수정" onclick="location.href='updateForm.jsp?idx=<%=idx%>'">
					<input type="button" value="삭제" onclick="location.href='deleteForm.jsp?idx=<%=idx%>'">
					<input type="button" value="목록" onclick="location.href='list.jsp'">
				</td>
			</tr>
		</table>
	<%
	}
	%>
	
</body>
</html>