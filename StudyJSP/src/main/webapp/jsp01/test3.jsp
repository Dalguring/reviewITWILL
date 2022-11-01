<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Calendar c = Calendar.getInstance();
int hour = c.get(Calendar.HOUR_OF_DAY);
int min = c.get(Calendar.MINUTE);
int sec = c.get(Calendar.SECOND);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test2.jsp - 스크립틀릿과 표현식 연습</h1>
	<h3><%=hour%>시 <%=min%>분 <%=sec%>초</h3>
	<% //스크립틀릿 내부에서 HTML어디든 사용가능
	if(hour<12) {
		out.println("<h3>오전입니다.</h3>");
	} else {
		out.println("<h3>오후입니다.</h3>");
	}
	%>
	<hr>
	<%
	if(hour<12) {
		%><h3>오전입니다.</h3><%
	} else {
		%><h3>오후입니다.</h3><%
	}
	%>
	
	<hr>
	
	<%!
	public int sum() {
		int total = 0;
		for(int i = 1; i <=100; i++) {
			total += i;
		}
		return total;
	}
	%>
	<h3>1 ~ 100까지 정수의 합 = <%=sum() %></h3>
</body>
</html>