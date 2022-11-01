<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function showWindowInfo() {
		document.write("창의 높이 : " + window.innerHeight + ", 창 너비 : " + window.innerWidth);
	}
	function changeBackgroundColor() {
		document.body.style.background = "red";
	}
	function connectUrl() {
		var url = prompt("이동할 페이지 URL 입력!", "http://");
		var i = confirm(url + "주소로 이동하시겠습니까?")
		if(i) {
			location.href = url;
		}
	}
	function showBrowserInfo() {
		alert("브라우저 정보 : " + navigator.userAgent + ", 브라우저 OS 정보 : " + navigator.platform);
	}
	
 </script>
</head>
<body>
	<h1>test12.jsp - window 객체</h1>
	<input type="button" value = "창 크기 확인" onclick="showWindowInfo()">
	<input type="button" value = "배경색 변경" onclick="changeBackgroundColor()">
	<input type="button" value = "URL 입력" onclick="connectUrl()">
	<input type="button" value = "브라우저 정보 확인" onclick="showBrowserInfo()">
	
</body>
</html>