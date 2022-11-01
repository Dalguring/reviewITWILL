<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
// 	var inputData = prompt();
// 	document.write(inputData);	
	function getMessage() {
		return "Hello, World!";
// 		return 10;
	}
	var result = getMessage();
	document.write(result + "<br>"+ typeof(result) + "<br>");
	
	document.write("<hr>");
	//=================================================================================
	function gettotal() {
		var total = 0;
		for(var i=1; i<=10; i++) {
			total += i;
		}
		return total; // total은 gettotal()이라는 function안에서만 쓰이므로 사라지는데, 이를 
					  // return을 이용해 gettotal()함수에 저장을 함. 따라서 gettotal()=total=55
	}
	var result = gettotal();
	document.write(result);
	
		
</script>
</head>
<body>

</body>
</html>