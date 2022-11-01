<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var value = 10;
	document.write(value + " 의 변환 전 타입 : " + typeof(value) + "<br>");
	value = String(value);
	document.write(value + " 의 변환 후 타입 : " + typeof(value) + "<br>");
	
	var value2 = true;
	document.write(value + " 의 변환 전 타입 : " + typeof(value2) + "<br>");
	value2 = String(value2);
	document.write(value + " 의 변환 후 타입 : " + typeof(value2) + "<br>");
	
	document.write("<hr>")
	document.write("10" / "2"); //문자열로 정의했지만 자동형변환에 의해 number타입으로 변환됨
	document.write("<br>")
	
	var strNum = prompt("정수를 입력하세요");
	document.write(strNum + " 의 변환 전 타입 : " + typeof(strNum) + "<br>");
	var num = Number(strNum);
	document.write(num + " 의 변환 후 타입 : " + typeof(num) + "<br>"); //number타입
	
	//swtich-case 문에서 case 문 사용 시 number 타입을 비교하는 경우에
	//switch문에 전달된 데이터가 string 타입일 경우 강제 형변환을 수행해야만 숫자로 비교가능
	
// 	switch (strNum) {
// 		case 1 : document.write("1입니다!<br>") break;
// 		case 2 : document.write("2입니다!<br>") break;
// 		default : document.write("일치하는 데이터가 없습니다!<br>") break;
// 	}
// 	document.write("<hr>");
// 	switch (Number(strNum)) {
	
// 	case 1 : document.write("1입니다!<br>") break;
// 	case 2 : document.write("2입니다!<br>") break;
// 	default : document.write("일치하는 데이터가 없습니다!<br>") break;
// 	} 
// 	숫자 데이터 외의 다른 데이터(문자 등)가 포함되어 있을 경우 변환 수행 시 NaN값이 저장됨
// 	=> NaN = Not a Number의 약자로 숫자가 아닌 데이터라는 의미로 사용됨
//  즉, 변환 시 오류가 발생하는 것이 아니라 NaN 값이 저장됨
	document.write("<hr>");
	var strNum2 = "1234a";
	document.write(strNum2 + " 의 변환 전 타입 : " + typeof(strNum2) + "<br>");
	var num2 = Number(strNum2);
	document.write(num2 + " 의 변환 후 타입 : " + typeof(num2) + "<br>");

</script>
</head>
<body>

</body>
</html>