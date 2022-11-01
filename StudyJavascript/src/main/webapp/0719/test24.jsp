<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function itemSelected() {
		alert(document.fr.fruits3.value);
	}
	function itemSelected2(value) {
// 		if(value=="") {
// 			alert("과일 선택 필수");
// 		} else {
// 			alert(value + " : 선택됨");
// 		}
		if(document.fr.fruits4.options[0].selected) {
			alert("과일 선택 필수");
		}
	}
	function check() {
		if(document.fr.fruits4.options[0].selected) {
			alert("과일 선택 필수");
			document.fr.fruits4.focus();
		} else {
			document.fr.submit();
		}
	}

</script>
</head>
<body>
	<h1>test24.jsp</h1>
	<form action = "a.jsp" method = "get" name = "fr">
		<select name = "fruits">
			<option value="Apple">사과</option>
			<option value="Banana">바나나</option>
			<option value="Lemon">레몬</option>
		</select>
		<hr>
		<select name = "fruits2">
			<option value="Apple">사과</option>
			<option value="Banana" selected="selected">바나나</option>
			<option value="Lemon" disabled="disabled">레몬</option>
		</select>
		<hr>
		<select name = "fruits3" onchange="itemSelected()">
			<option value="Apple">사과</option>
			<option value="Banana">바나나</option>
			<option value="Lemon">레몬</option>
		</select>
		<hr>
		<select name = "fruits4" onchange="itemSelected2(this.value)">
			<option value="">과일을 선택하세요</option>
			<option value="Apple">사과</option>
			<option value="Banana">바나나</option>
			<option value="Lemon">레몬</option>
		</select>
		<br>
		<input type="button" value="확인" onclick="check()">
	</form>
</body>
</html>