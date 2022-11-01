<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String cookieId = "";

String cookieHeader = request.getHeader("Cookie");

if(cookieHeader != null) {
	Cookie[] cookies = request.getCookies();
	
	for(Cookie cookie : cookies) {
		if(cookie.getName().equals("cookieId")) {
			cookieId = cookie.getValue();
		}
	}
	
}
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="loginPro.jsp" method="post">
		<table>
			<tr>
				<th>아이디</th>
<%-- 				<td><input type="text" name="id" <%if(!cookieId.equals("")) {%>value="<%=cookieId %>"<%} %> required="required"> --%>
				<td><input type="text" name="id" value="${cookie.cookieId.value }" required="required"></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="passwd" required="required">
			</tr>
			<tr>
				<td colspan="2"><input type="submit" id = "sub" value="로그인"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="checkbox" name="rememberId" >ID 기억하기</td>
			</tr>
		</table>
	</form>
</body>
</html>