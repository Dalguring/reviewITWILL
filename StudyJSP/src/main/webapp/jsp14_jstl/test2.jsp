<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
int num = 20;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test2.jsp</h1>
<!-- 	c:set 태그를 사용하여 변수 설정(선언 및 초기화) -->
<!-- 	=> var 속성에 변수명, value 속성에 변수값 지정 -->
<!-- 	=> scope 속성을 사용하여 변수의 유효범위 지정 가능하며, 생략 시 page 속성이 지정됨 -->
<!-- 		(현재 페이지에서만 유효한 변수로 선언됨) -->
<!-- 	=> 선언(생성)된 변수는 EL을 사용하여 접근 가능함	 -->
	<c:set var="str" value="Hello, World!" />
<!-- 	c.set 태그를 통해 생성된 str 변수를 EL 을 통해 접근 가능 -->
	<h3>\${str } = ${str }</h3>
<%-- 	<%주의! c:set 태그를 통해 생성된 str 변수는 표현식 등의 자바 문법 기준으로는 존재하지 않는 변수이므로 접근 불가 %> --%>
<%-- <%주의! 자바 문법으로 선언된 변수를 EL에서 사용하려면 JSTL에서의 변수로 변환해야함 %> --%>
<%-- 	<h3>\${num } = ${num }</h3> num값이 출력되지 않는다! --%>
	
	<%int num2 = 100; %>
	<c:set var="num2" value="<%=num2 %>"/>
	<h3>\${num2 } = ${num2 }</h3>
	
	<hr>
<!-- 	c:remove 태그를 사용하여 변수값 삭제(주의! c:set 태그에서 사용된 var 속성의 변수명만 지정) -->
	<c:remove var="str"/>
	<h3>\${str } 값 삭제 후 = ${str }</h3>
	<h3>\${str } 값이 비어있는가? = ${empty str }</h3>
	
</body>
</html>