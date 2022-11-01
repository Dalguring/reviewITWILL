<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function btnClick() {
		alert("버튼5 클릭됨!");
	}
	function btnClick2(text) {
		alert(text + " 클릭됨!");
	}

	function btnClick3() {
		return "리턴값";
	}
	function inputAnswer() {
		var answer = prompt("정답을 입력하세요");
// 		document.write("입력하신 정답은 " +answer+ "입니다.");
		if(answer=="자바") {
			alert("정답입니다!");
		} else {
			alert("오답입니다!");
		}
	}
	function goInputUrl() {
		var url = prompt("이동할 페이지 URL 입력!");
// 		alert(url);
		location.href = url;
	}
</script>
</head>
<body>
	<h1>test11.jsp</h1>
	<!-- HTML태그에서 버튼을 부착하는 방법 
	1) <input> 태그의 type = "button"속성 사용
	2) <button> 태그 사용 => 태그 사이에 버튼 텍스트 지정
	-->
	
	<input type = "button">
	<input type = "button" value = "버튼">
	<button>버튼2</button>
	<hr>
	<input type = "button" value = "버튼1" onclick="alert('버튼1 클릭됨!')">
	<button onclick="alert('버튼2 클릭됨!')">버튼2</button>
	<input type = "button" value = "버튼3" ondblclick="alert('버튼3 더블클릭됨!')">
	<input type = "button" value = "버튼4" onmouseover="alert('버튼4 마우스오버!')" onmouseout="alert('버튼4 마우스아웃!')">
	<input type = "button" value = "버튼5" onclick="btnClick()">
	<input type = "button" value = "버튼6" onclick="btnClick2('버튼6')">
	<input type = "button" value = "버튼7" onclick="alert(btnClick3())">
	<hr>
	<input type = "button" value = "정답입력" onclick="inputAnswer()">
	<hr>
	<a href = "http://www.itwillbs.co.kr"><button>아이티윌 부산교육센터</button></a>	
	<button onclick="location.href='http://www.itwillbs.co.kr'">아이티윌 부산교육센터</button>
	<button onclick="goInputUrl()">URL 입력</button>
	
</body>
</html>