<%@page import="java.util.ArrayList"%>
<%@page import="jsp14_jstl.memberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test4_result.jsp</h1>
<%-- 	<h3>번호 : <%=request.getAttribute("idx") %></h3> --%>
<%-- 	<h3>이름 : <%=request.getAttribute("name") %></h3> --%>
	<%
	int idx = (int)request.getAttribute("idx");
	String name = (String)request.getAttribute("name");
	%>
<%-- 	<h3>번호 : <%=idx %></h3> --%>
<%-- 	<h3>이름 : <%=name %></h3> --%>
<!-- 	request.getAttribute() 메서드 대신 EL 문법을 사용하여 속성명을 직접 지정 시 데이터 접근 가능 -->
<!-- 	pageContext, request, session, application 영역을 차례대로 검사하여 일치하는 속성을 자동으로 꺼내옴 -->
<%-- 	${속성명 } 형식으로 지정(주의! request.getParameter() 와 다름 ${param.파라미터명 } 문법과 다름) --%>
	<h3>번호(\${idx }) : ${idx }</h3>
	<h3>이름(\${name }) : ${name }</h3>
	<hr>
<!-- 	request 객체에 저장된 memberDTO 객체로부터 멤버변수 값을 꺼내서 출력하기 -->
<%-- 	=> ${속성명.변수명 } 형식으로 지정 --%>
<!-- 	=> 주의! 실제 변수에 직접 접근하는 것이 아닌 해당 변수에 맞는 Getter를 자동으로 호출함 -->
<!-- 	request.getAttribute() 메서드 호출까지 생략되어 문장이 매우 간결해짐(별도의 형변환도 불필요) -->
	<h3>아이디 : ${member.id }</h3>
	<h3>패스워드 : ${member.passwd }</h3>
	<h3>이름 : ${member.name }</h3>
	<h3>나이 : ${member.age }</h3>
	<hr>
<!-- 	일반적인 for문을 사용하여 제어변수 i값이 1 ~ 10까지 1씩 증가하면서 반복 => i값 출력 -->
	<%
	for(int i = 1; i <= 10; i++) { %>
		<%=i %>&nbsp;
	<%} %>
	<hr>	
<!-- 	JSTL의 c:forEach 태그를 사용하여 위의 for문과 동일한 작업 수행 -->
	<c:forEach var="i" begin="1" end="10" step="1">
<!-- 		i를 1부터 10까지 1씩 증가하는 forEach문 -->
		${i }&nbsp;
	</c:forEach>
	<hr>
	<!-- 		i를 10부터 1까지 1씩 감소하는 forEach문 -->
<%-- 	<c:forEach var="i" begin="10" end="1" step="-1"> --%>
<%-- 		${i }&nbsp; --%>
<%-- 	</c:forEach> --%>

	<!-- 		i를 1부터 10까지 2씩 증가하는 forEach문 -->
	<c:forEach var="i" begin="1" end="10" step="2">
		${i }&nbsp;
	</c:forEach>
	<hr>
<!-- 	자바의 객체에 접근하여 객체 내의 데이터를 차례대로 접근하는 forEach문 -->
	<c:forEach var="item" items="${names }" varStatus="status">
<!-- 		names 라는 이름의 속성명을 갖는 객체(배열 포함)에서 값을 차례대로 꺼내서 item이라는 변수에 저장 -->
<!-- 		varStatus 속성에 지정된 이름으로 객체의 상태 정보 관리(이름.index 지정 시 인덱스 값 가져올 수 있음) -->
		${status.index } 번 배열 데이터 : ${item }<br>
	</c:forEach>
	<hr>
	<%
	List<memberDTO> memberList = (List<memberDTO>)request.getAttribute("memberList");
	for(memberDTO member : memberList) {
		out.println(member.getId() + " " + member.getPasswd() + " " + member.getName() + " " + member.getAge()+"<br>");
	}
	%>
	<hr>
	<c:forEach var="member" items="${memberList }">
		${member.id }, ${member.passwd }, ${member.name }, ${member.age }<br>
	</c:forEach>
	
	<hr>
	<%
	// 1명의 회원정보를 memberDTO객체에 저장
	memberDTO member2 = new memberDTO("hong", "1234", "홍길동", 20);
	// 현재 페이지내에서 생성한 객체를 현재 페이지 내에서 JSTL 등을 통해 접근해야할 경우
	// pageContext 객체의 setAttribute() 메서드를 사용하여 현재 페이지에 객체 형태로 저장해야함
	pageContext.setAttribute("member2", member2);
	%>
	${member2.id }, ${member2.passwd }, ${member2.name }, ${member2.age }<br>
	
	
	
	
</body>
</html>