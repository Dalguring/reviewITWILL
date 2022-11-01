<%@page import="java.util.ArrayList"%>
<%@page import="jsp14_jstl.memberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// request 객체에 데이터 저장 후 test4_result.jsp 페이지로 포워딩(Dispatcher 방식)
request.setAttribute("idx", 3);
request.setAttribute("name", "홍길동");

// 1명의 회원정보를 memberDTO객체에 저장
memberDTO member = new memberDTO("hong", "1234", "홍길동", 20);
request.setAttribute("member", member);

// 1명의 회원정보가 저장된 memberDTO 객체를 생성하고 ArrayList객체에 memberDTO 객체 저장
List<memberDTO> memberList = new ArrayList<memberDTO>();
memberList.add(new memberDTO("admin", "1234", "관리자", 0));
memberList.add(new memberDTO("hong", "1234", "홍길동", 20));
memberList.add(new memberDTO("leess", "1234", "이순신", 44));
// 생성된 ArrayList 객체도 request 객체에 저장
request.setAttribute("memberList", memberList);

// String 타입 배열 생성 및 "홍길동", "이순신", "강감찬" 저장 후 request 객체에 저장
String[] names = {"홍길동", "이순신", "강감찬"};
request.setAttribute("names", names);

// request 객체를 유지하면서 test4_result.jsp 페이지로 포워딩하기 위해
// Redirect 방식(response.sendRedirect()) 대신 Dispatcher 방식(pageContext.forward())의 포워딩 사용
pageContext.forward("test4_result.jsp");
// 주소 표시줄에 이전 요청 주소인 http://localhost:8080/StudyJSP/jsp14_jstl/test4.jsp 주소가 그대로 유지됨
%>