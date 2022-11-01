<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forwardPro.jsp</h1>
	
	<% //변수 자체를 들고가는게 아니고 request값의 데이터만 들고 가는것임.
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String jumin = request.getParameter("jumin");
	String name = request.getParameter("name");
	int num = 100;
	%>
	
	<h3>아이디 : <%=id %></h3>
	<h3>패스워드 : <%=passwd %></h3>
	<h3>주민번호 : <%=jumin %></h3>
	<h3>이름 : <%=name %></h3>
	<hr>
	
<%-- 	<jsp:forward page="forwardPro2.jsp"/> --%>
<%-- 	<jsp:forward page="forwardPro2.jsp?num=100"/> --%>
	<jsp:forward page="forwardPro2.jsp">
		<jsp:param name="num" value="<%=num %>" />
		<jsp:param name="str" value="forward 액션 태그의 param 데이터" />
	</jsp:forward>
</body>
</html>