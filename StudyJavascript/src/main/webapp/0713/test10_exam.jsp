<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "test10.js"></script>
<script type="text/javascript">
// 	function sum(num) {
// 		var total = 0;
// 		for(var i = 1; i <=num; i++) {
// 			total += i;
// 		}
// 		return total;
// 	}
// 	var result = sum(10);
// 	document.write("합계 = " + result);
	
// 	var p = sum(prompt());
// 	document.write(p);
	document.write("<hr>");
	var isSuccess = login("admin", "124");
	if(isSuccess==true) {
		alert("로그인 성공!");
	} else {
		alert("로그인 실패!");
	}
</script>
</head>
<body>

</body>
</html>