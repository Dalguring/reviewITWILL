<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/* 
	if문
	- 자바에서의 if문과 동일
	- 특정 조건에 따라 문장을 실행하는 조건문
	- 조건식은 반드시 결과가 true 또는 false인 식만 사용가능하며, 변수도 사용 가능함
	====================================================================================
	1. 단일 if문
// 	- if문에 주어진 조건을 판별하여 true일 경우 지정된 블럭 내의 문장들을 수행하는 if문
	
// 	< 기본 문법 >
// 	if(조건식) {
// 		// 조건식의 판별 결과가 true일 때 실행할 문장들	
// 	}
// 	*/
// 	var num=-10;
// 	if(num > 0) {
// 		document.write(num + " : 이 0보다 크다!<br>");
// 		document.write("그러므로, 이 문장은 웹브라우저에 표시된다!<br>");
// 	}
	
// 	document.write("이 문장은 if문 판별 결과와 상관없이 실행된다!");
// 	document.write("<hr>");
// 	//==================================================================================
// 	// if ~ else문
// 	var num2=-10;
// 	if(num2>0) {
// 		document.write(num2 + " : 이 0보다 크다!<br>");
// 		document.write("그러므로, 이 문장은 웹브라우저에 표시된다!<br>");
// 	} else {
// 		document.write(num2 + " : 이 0보다 크지않다!<br>");
// 		document.write("그러므로, 0보다 크지 않을 경우 이 문장은 웹브라우저에 표시된다!<br>");		
// 	}
	
// 	document.write("이 문장은 if문 판별 결과와 상관없이 실행된다!");
// 	document.write("<hr>");
// 	//==================================================================================
// 	var age = prompt("나이를 입력하세요");
// 	document.write("나이 : " + age);
// 	if(age>0) {
// 		document.write("정상");
// 	} else {
// 		document.write("잘못된 입력");
// 	}
	
// 	var num3 = 0;
// 	if(num3>0) {
// 		document.write(num3 + " : 이 0보다 크다!<br>");
// 	} else if(num3<0) {
// 		document.write(num3 + " : 이 0보다 작다!<br>");
// 	} else {
// 		document.write(num3 + " : 이 0과 같다!<br>");
// 	}
// 	document.write("<hr>");
	
	var age = 15;
	if(age>=10 && age<20) {
		document.write("10대 입니다");
	} else {
		document.write("10대가 아닙니다");
	}

</script>
</head>
<body>
	
</body>
</html>