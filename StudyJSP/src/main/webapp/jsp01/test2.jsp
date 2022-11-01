<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
String str1 = "멤버(전역) 변수입니다.";

public void method1() {
	System.out.println("선언문 내의 method1() 메서드 호출됨!");
}

public String method2() {
	return "method2() 메서드의 리턴값";
}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test.jsp</h1>
	<h3>멤버변수 str1 = <%=str1 %></h3>
<%-- 	<h3>method1() 메서드 호출 결과 : <%= method1() %></h3> --%>
	<h3>method2() 메서드 호출 결과 : <%= method2() %></h3>
<%-- 	<h3>로컬변수 str2 = <%=str2 %></h3> --%>
	<%
	//이 곳은 스크립틀릿 내부입니다.
	String str2 = "로컬(지역) 변수입니다";
	method1();
	System.out.println("이 문장은 이클립스 콘솔에 출력됩니다.");
	
	out.println("<h3>스크립틀릿에서 출력한 데이터</h3>");
	
// 	public void method3() {} 스크립틀릿 내부에서는 메서드 정의 불가(= 자바에서 메서드 내에 메서드 정의 불가)
	%>
	
	<h3>로컬변수 str2 = <%=str2 %></h3>
	<%=str3 %>
	<%! String str3 = "멤버변수 str3입니다";%>
	<%=str3 %>
</body>
</html>