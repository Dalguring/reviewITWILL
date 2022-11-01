<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function func1() {
// 		window.open();
		window.open("", "", "width=300, height=300");
	}
	function func2() {
		window.open("test12.jsp", "창 이름", "width=600, height=600,scrollbars=yes");
		}
	function func3() {
		window.close();
	}
	function func4() {
		window.open("test13_sub.jsp", "창 이름", "width=1200, height=800");
	}

</script>
</head>
<body>
	<h1>test13.jsp - window 객체</h1>
	<input type = "button" value = "창 열기1" onclick="func1()">
	<input type = "button" value = "창 열기2" onclick="func2()">
	<input type = "button" value = "창 닫기" onclick="func3()">
	<input type = "button" value = "test13_sub.jsp 열기" onclick="func4()">
	
</body>
</html>