<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>requestPro4.jsp</h1>
	<h3>아이디 : <%=id %></h3>
	<h3>패스워드 : <%=passwd %></h3>
	<%
// 	if(id.equals("admin") && passwd.equals("1234")) { 
// 		out.println("로그인 성공!");
// 	} else { 
// 		out.println("로그인 실패!");
// 	}
	%>
	
	<% if(id.equals("admin") && passwd.equals("1234")) {%>
		<script type="text/javascript">
// 			location.href = "requestPro4_responseResult1.jsp";
		</script>
	<%} else { %>
		<script type="text/javascript">
// 			location.href = "requestPro4_responseResult2.jsp";
		</script>
	<%} %>
	
	<%--자바의 response 객체를 사용 --%>
	<%
	if(id.equals("admin") && passwd.equals("1234")) { 
		response.sendRedirect("requestPro4_responseResult1.jsp");
	} else { 
		response.sendRedirect("requestPro4_responseResult2.jsp");
	}
	%>
	
	
	
</body>
</html>