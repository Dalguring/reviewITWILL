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
	int idx = Integer.parseInt(request.getParameter("idx"));
	if(request.getParameter("idx") == null) {
	%>
	<script>
		alert("잘못된 접근입니다!");
		location.href="../index.jsp";
	</script>
	<%
	}
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/study_jsp3";
	String user = "root";
	String password = "1234";
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, user, password);
	String sql = "SELECT * FROM board WHERE idx=?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, idx);
	ResultSet rs = pstmt.executeQuery();
	
	if(rs.next()) {
		%>
		<h1>글 수정</h1>
		<form action="updatePro.jsp" method="post">
		<input type="hidden" name="idx" value="<%=idx %>">
			<table border="1">
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name" required="required" readonly="readonly" value="<%=rs.getString("name") %>"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="passwd" required="required"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="subject" required="required" value="<%=rs.getString("subject")%>"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" rows="10" cols="20" required="required"><%=rs.getString("content")%></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="수정" >
					<input type="reset" value="초기화">
					<input type="button" value="취소" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
		<%
	} else {
	%>
		<script>
			alert("잘못된 접근입니다!");
			location.href="../index.jsp";
		</script>
	<%
	}
	%>
</body>
</html>