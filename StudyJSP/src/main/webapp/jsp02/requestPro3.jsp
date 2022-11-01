<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>requestPro3.jsp - 학생 정보 출력</h1>
	<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String grade = request.getParameter("grade");
	String[] hobbies = request.getParameterValues("hobby");
	%>
	<table border="1">
		<tr>
			<td>이름</td>
			<td><%=name %>
		</tr>
		<tr>
			<td>나이</td>
			<td><%=age %>
		</tr>
		<tr>
			<td>성별</td>
			<td><%=gender %>
		</tr>
		<tr>
			<td>학년</td>
			<td><%=grade %>
		</tr>
		<tr>
			<td>취미</td>
			<td>
			<%
			if(hobbies!=null) {
				for(int i = 0; i < hobbies.length; i++) {
					out.println(hobbies[i] + " ");
				}
			} else {
				out.println("없음");
			}
			%>
		</tr>
	</table>
	
</body>
</html>