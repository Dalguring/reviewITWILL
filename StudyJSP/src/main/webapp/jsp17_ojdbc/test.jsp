<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	/*
	[ JDBC를 활용하여 Oracle DB접속 ]
	- Oracle JDBC(OJDBC) 라이브러리 활용
	- 기본적인 표준 쿼리만 사용한다고 가정했을 때 MySQL과 1단계 2단계 정보만 다름
	  (접근 방법은 동일 = JDBC는 공통된 방법으로 DB에 접근할 수 있도록 도와줌)
	1단계. 드라이버 로드
	- oracle.jdbc.OracleDriver 클래스필요
	
	2단계. DB 연결
	- MySQL의 경우 "jdbc:mysql://DB주소:포트번호/DB명"
	- Oracle의 경우 "jdbc:oracle:thin:@DB주소:포트번호:DB명"
	  => 기본 서비스 포트 : 1521번
	*/
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.3.128:1521:orcl";
	String user = "hr";
	String password = "hr";
	
	Class.forName(driver);
	
	Connection con = DriverManager.getConnection(url, user, password);
	%>
	<h3>Oracle DB 연결 성공</h3>
	<hr>
	
	<%
	// orcl 데이터베이스에 test_ojdbc 테이블 생성
	// => 컬럼 : idx(번호) - 정수(INT), name - 이름(VARCHAR2(10))
	String sql = "CREATE TABLE test_ojdbc (idx NUMBER(8), name VARCHAR2(10))";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.executeUpdate();
	
	pstmt.close();
	con.close();
	
	out.println("<h3>SQL 구문 실행 성공</h3>");
	%>
	
</body>
</html>