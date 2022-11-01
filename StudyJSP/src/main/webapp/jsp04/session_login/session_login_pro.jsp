<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

// out.println(id + ", " + passwd);
String dbId = "admin";
String dbPasswd = "1234";

if(id.equals(dbId) && passwd.equals(dbPasswd)) {
	session.setAttribute("sId", id);
	response.sendRedirect("session_login_main.jsp");
} else {%>
	<script>
		alert("로그인 실패!");
		history.back();
	</script>
	<%
}
%>
