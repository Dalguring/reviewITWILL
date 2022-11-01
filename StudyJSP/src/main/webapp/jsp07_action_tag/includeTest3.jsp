<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String pageName = request.getParameter("pageName");
if(pageName==null) {
	pageName="main";
}

pageName = "includeTest3_" + pageName + ".jsp"; 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="2" width="1024" height="200">
				<jsp:include page="includeTest3_top.jsp">
					<jsp:param name="id" value="admin" />
				</jsp:include>
			</td>
		</tr>
		<tr>
			<td width="200" height="500">
				<jsp:include page="includeTest3_left.jsp" />
			</td>
			<td>
				
<%-- 				<jsp:include page="includeTest3_main.jsp" /> --%>
<%-- 				<jsp:include page='<%="includeTest3_" + pageName + ".jsp" %>' /> --%>
				<jsp:include page="<%=pageName %>"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" height="200">
				<jsp:include page="includeTest3_bottom.jsp" />
			</td>
		</tr>
	</table>
</body>
</html>