<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String sId = (String)session.getAttribute("sId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="right">
		<%if(sId==null) {%>
			<a href = "member/loginForm.jsp">로그인</a> | <a href = "member/joinForm.jsp">회원가입</a>
		<%} else { %>
			<%=sId %>님 | <a href = "member/logout.jsp">로그아웃</a>
			<%if(sId.equals("admin")) {%>
				| <a href="admin/admin_main.jsp">관리자페이지</a>
			<% }%>
		<%} %>
		<!-- top.jsp는 index.jsp에 포함돼있으므로 index.jsp기준으로 상대경로를 설정해야함 -->
	</div>
	<div align="center">
		<a href="index.jsp">HOME</a>상단메뉴1 상단메뉴2 상단메뉴3 상단메뉴4 상단메뉴5
	</div>
</body>
</html>