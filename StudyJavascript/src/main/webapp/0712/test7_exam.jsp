<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 외부 자바스크립트 파일인 test7.js 파일을 포함시키기- -->
<script type="text/javascript" src="test7.js"></script>
<script type="text/javascript">
// 	function showMessage() {
// 		alert("함수 호출됨!");
// 	}
// 	showMessage();
	//---------------------------------------------------------------------------------------
	function printNum() {
		for(var i = 1; i<=10; i++)
			document.write(i + " ");
	}
	printNum();
	document.write("<br>");
	function sum() {
		var total = 0;
		for(var k = 1; k <= 10; k++) {
			total += k;
		}
		document.write(total);
	}
	sum();
	//외부 자바스크립트 test7.js 내의 checkNumGame 함수 호출
	checkNumGame();
	document.write("<hr>");
	document.write(count);
	
	
</script>
</head>
<body>

</body>
</html>