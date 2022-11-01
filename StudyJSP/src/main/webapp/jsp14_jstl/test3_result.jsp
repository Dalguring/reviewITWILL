<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test3_result.jsp</h1>
<!-- 	자바에서 가장 많이 사용하는 문장에 대한 JSTL 문법(조건문, 반복문 등) -->
	<c:set var="num2" value="10" />
<!-- 	EL을 사용해서 파라미터 name, num 및 변수 num2값 출력 -->
	\${param.name } = ${param.name }
	\${param.num } = ${param.num }
	\${num2 } = ${num2 }
	<hr>
	<c:if test="${param.num gt 0 }">
		<h3>\${param.num }이 0보다 크다!</h3>
		<h3>그러므로 이 태그는 현재 페이지에서 출력된다</h3>
	</c:if>
	<hr>
<!-- 	if ~ else if ~ else -->
	<c:set var="num3" value="0"/>
	<c:choose>
		<c:when test="${num3 gt 0}">
			<h3>num3(${num3 }) : 양수!</h3>
		</c:when>
		<c:when test="${num3 lt 0}">
			<h3>num3(${num3 }) : 음수!</h3>
		</c:when>
		<c:otherwise>
			<h3>num3(${num3 }) : 0</h3>
		</c:otherwise>
	</c:choose>
	<hr>
	<c:choose>
		<c:when test="${param.name eq '홍길동'}">
			<h3>홍길동입니다!</h3>
		</c:when>
		<c:when test="${param.name eq '이순신'}">
			<h3>이순신입니다!</h3>
		</c:when>
		<c:when test="${empty param.name}">
			<script type="text/javascript">
				alert("이름 입력 필수!");
				history.back();
			</script>
		</c:when>
		<c:otherwise>
			<h3>그 외 나머지!</h3>
		</c:otherwise>
	</c:choose>
	
</body>
</html>