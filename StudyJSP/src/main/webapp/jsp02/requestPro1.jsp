<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>requestPro1.jsp</h1>
	<h1>request 객체 예제(처리 페이지)</h1>
	<%
	request.setCharacterEncoding("UTF-8"); 
	String strName = request.getParameter("name");
// 	out.println("이름 : " + strName + "<br>");
	String strAge = request.getParameter("age");
// 	out.println("나이 : " + strAge + "<br>");
	String strGender = request.getParameter("gender");
// 	out.println("성별 : " + strGender + "<br>");
// 	String strHobby = request.getParameter("hobby");
// 	out.println("취미 : " + strHobby + "<br>");

	String[] strHobbies = request.getParameterValues("hobby");
	%>
	<table border="1">
		<tr>
			<th>이름</th><td><%=strName %></td>
		</tr>
		<tr>
			<th>나이</th><td><%=strAge %></td>
		</tr>
		<tr>
			<th>성별</th><td><%=strGender %></td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				<%
// 				for(int i = 0; i < strHobbies.length; i++) {
// 					out.println(strHobbies[i] + " ");
// 				} 
				%>
				
<%-- 				<%if(strHobbies == null) { %> --%>
					<script type="text/javascript">
// 						alert("취미 선택 필수!");
// 						history.back();
					</script>
<%-- 				<%}%> --%>

				<%
				if(strHobbies==null) {
					out.println("없음");
				} else {
					for(int i = 0; i < strHobbies.length; i++) {
						out.println(strHobbies[i] + " ");
					} 
				}
				%>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type = "button" value = "뒤로가기" onclick="history.back()"></td>
		</tr>
		
	</table>
	
</body>
</html>