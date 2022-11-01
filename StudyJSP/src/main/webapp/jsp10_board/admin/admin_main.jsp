<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String sId = (String)session.getAttribute("sId");
if(sId == null || !sId.equals("admin")) { %>
	<script>
		alert("잘못된 접근입니다!");
		location.href="../index.jsp";
	</script>
<%	
}
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자 페이지</h1>
</body>
</html>