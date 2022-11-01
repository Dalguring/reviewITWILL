<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function print() {
// 		var id = document.fr.id.value;
// // 		var id = document.id.value; 동작 x
// 		alert(id);
		alert(document.fr.id.value + "\n" + document.fr.passwd.value + "\n" + document.fr.ta.value);
	}
	function check() {
// 		alert(document.fr.id.value + "\n" +document.fr.ta.value);
		if(document.fr.id.value=="") {
			alert("아이디 입력 필수");
			document.fr.id.focus();
			return;
		} else if(document.fr.passwd.value.length==0) {
			alert("패스워드 입력 필수");
			document.fr.passwd.focus();
			return;
		} else if(document.fr.ta.value=="") {
			alert("자기소개 입력 필수");
			document.fr.ta.focus();
			return;
		}
		alert("모든 항목 입력 체크 완료!");
		document.fr.submit();
	}
	
	function check2() {
		if(document.fr.id.value=="") {
			alert("아이디 입력 필수");
			document.fr.id.focus();
			return false;
		} else if(document.fr.passwd.value.length==0) {
			alert("패스워드 입력 필수");
			document.fr.passwd.focus();
			return false;
		} else if(document.fr.ta.value=="") {
			alert("자기소개 입력 필수");
			document.fr.ta.focus();
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<h1>test22.jsp - form태그</h1>
	<form action="test22-2.jsp" method = "get" name="fr" onsubmit="return check2()">
		아이디 <input type="text" name = "id">
		<input type = "button" value = "focus()" onclick = "document.fr.id.focus()">
		<input type = "button" value = "blur()" onclick = "document.fr.id.blur()">
		<input type = "button" value = "select()" onclick = "document.fr.id.select()">
		<br>
		패스워드 <input type="password" name = "passwd" required="required">
		<br>
		자기소개 <textarea rows="5" cols="20" name = "ta"></textarea>
		<br>
		<input type = "button" value = "입력값 출력" onclick = "print()">
		<input type = "button" value = "입력값 체크" onclick = "check()">
		<input type = "reset" value = "초기화">
		<input type = "submit" value = "전송">
	</form>
</body>
</html>