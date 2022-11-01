<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function windowClose() {
		window.opener.alert("새 창(자식)을 닫았습니다!");
		window.close();
	}

</script>
</head>
<body>
	<h1>test13_sub.jsp - 자식창</h1>
	<input type = "button" value = "창 닫기" onclick="window.close()">
	<input type = "button" value = "창 닫기 및 알림 표시" onclick="windowClose()">
</body>
</html>