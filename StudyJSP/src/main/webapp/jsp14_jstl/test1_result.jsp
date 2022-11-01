<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
int num = Integer.parseInt(request.getParameter("num"));

String value = (String)session.getAttribute("testValue");
%>
<h3>이름 : <%=name %></h3>
<h3>값 : <%=num %></h3>
<h3>세션값 : <%=value %></h3>
<hr>
<h3>이름 : <%=request.getParameter("name") %></h3>
<h3>값 : <%=request.getParameter("num") %></h3>
<h3>세션값 : <%=session.getAttribute("testValue") %></h3>
<hr>
<%-- ============================================================== --%>

<!-- EL을 사용하여 request 객체의 파라미터 처리 -->
<%-- EL 내장 객체 param 사용 => ${param.파라미터명 } --%>
<h3>이름(\${param.name }) : ${param.name }</h3>
<h3>값(\${param.age }) : ${param.num }</h3>
<h3>세션값(\${sessionScope.testValue }) : ${sessionScope.testValue }</h3>
<hr>
<!-- 	EL의 연산자 -->
<h3>\${10 + 20 } = ${10+20 }</h3>
<!-- 파라미터값을 연산자를 통해 연산에 활용도 가능하며, 숫자 데이터의 경우 별도 형변환도 불필요(자동변환) -->
<h3>\${20 + param.num } = ${20 + param.num }</h3>
<h3>\${10 ge 20 } = ${10 ge 20 }</h3>
<!-- empty 연산자를 사용하여 비교 시 null 값이거나 값이 비어있거나 컬렉션 사이즈가 0일 경우 true 리턴 -->
<h3>\${empty param.name } = ${empty param.name }</h3>
<h3>\${not empty param.name } = ${not empty param.name }</h3>
<!-- 주의! 동등 비교 연산에 사용되는 eq 와 null을 조합하여 eq null 비교 시 진짜 null일때만 true 리턴됨 -->
<!-- 주로 지정한 파라미터 등이 존재하지 않을 경우(값이 없는 것이 아니라 파라미터 자체가 없는 것) -->
<h3>\${param.age eq null } = ${param.age eq null }</h3>
