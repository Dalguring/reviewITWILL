<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test7_dispatcher_result.jsp</h1>
	<!-- 이전 요청에서 전달받은 아이디(id), 패스워드(passwd) 파라미터 출력하기 -->
	<h3>아이디 : ${param.id }</h3>
	<h3>패스워드 : ${param.passwd }</h3>
	<!--
	Dispatcher 방식으로 포워딩 했으므로 이전 request 객체가 유지되어
	새로 포워딩 된 현재 페이지에서도 request 객체를 통해 이전 파라미터 값에 접근 가능하다!
	-->
</body>
</html>