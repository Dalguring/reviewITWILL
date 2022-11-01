<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/*
	2. 리턴값이 있는 함수 정의
	- 함수 실행 후 원래 위치로 돌아갈 때 데이터를 호출한 곳으로 전달하는 형태
	- 함수 선언 시 자바의 메서드와 달리 별도의 리턴타입은 명시하지 않고
	  함수 내부에서 return문을 사용하여 리턴할 데이터를 명시
	  => return 문에 지정된 데이터의 다입에 따라 리턴되는 데이터 타입이 자동으로 결정됨
	  - 함수를 호출한 곳에서 함수로부터 리턴되는 데이터를 전달받아 사용 가능
	  => 변수에 저장하거나 출력문 등의 함수 또는 연산에 즉시 사용도 가능함
	  - 리턴값은 동시에 하나의 값만 지정할 수 있음
	  
	  function 함수이름([매개변수...]) {
			외부로부터 함수가 호출될 경우 실행할 코드들
		return 리턴값; }
	*/
	function sister2() {
		document.write("동생 : 오빠가 물 떠오라고 시켜서 물을 떠왔다!<br>");
// 		var cup = "물" // 리턴할 데이터를 변수에 저장
		
// 		return cup;
		// 변수에 저장하지 않고 값(리터럴)을 직접 리턴도 가능함
		return "물";
	}
	document.write("동생아 물 좀 떠온나!<br>");
// 	var result = sister2();
// 	document.write("동생이 떠다 준 것 : " + result);

	//리턴값을 변수에 저장하지 않고 바로 사용하는 경우
	document.write("동생이 떠다 준 것 : " + sister2() + "<br>");
</script>
</head>
<body>

</body>
</html>