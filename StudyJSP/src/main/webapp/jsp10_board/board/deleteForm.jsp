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
if(request.getParameter("idx") == null) {%>
<script>
	alert("잘못된 접근입니다!");
	location.href="../index.jsp";
</script>
<%
}
%>
	<h1>글 삭제</h1>
	<form action="deletePro.jsp" method="post">
		<input type="hidden" name="idx" value="<%=request.getParameter("idx")%>">
		<table>
			<tr>
				<th>비밀번호</th><td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="삭제">
					<input type="button" value="돌아가기" onclick="history.back()">
			</tr>
		</table>
	</form>
</body>
</html>