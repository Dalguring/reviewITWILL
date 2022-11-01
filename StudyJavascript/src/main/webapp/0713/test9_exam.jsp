<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "test9.js"></script>
<script type="text/javascript">

	function showMessage(data) {
		document.write(data + " : " + typeof(data) + "<br>");
	}
	showMessage("Hello, World!");
	document.write("<hr>")
	function showMessage2(data="전달받은 데이터 없음") {
		document.write(data + " : " + typeof(data) + "<br>");
	}
	showMessage2("ff");
	document.write("<hr>");
	function count(num) {
		for(var i = 1; i <= num; i++) {
			document.write(i + " ");
		}
	}
	count(5)
	document.write("<hr>")
	
	function sum(num) {
		var k = 0;
		for(var i = 1; i <= num; i++) {
			 k += i;
		}
		document.write(k)
	}
	sum(10)
	document.write("<hr>")
	//=======================================================================
	
	function showMessage3 (name, age) {
		document.write(name, age);
	}
	showMessage3("서성민", 28);
	
	//=======================================================================
	login("admin", "1234");	
	
	
	
	
</script>
</head>
<body>

</body>
</html>