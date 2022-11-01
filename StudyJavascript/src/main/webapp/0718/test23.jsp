<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function printHobby() {
// 		alert(document.fr.hobby[0].value + " : " + document.fr.hobby[0].checked);
		var hobbyArr=document.fr.hobby;
		if(!hobbyArr[0].checked && !hobbyArr[1].checked && !hobbyArr[2].checked) {
			alert("취미를 최소 하나 이상 선택하세요!");
		}
		
	}
	
	function printGender() {
		var genderArr=document.fr.gender;
		if(!genderArr[0].checked && !genderArr[1].checked) {
			alert("성별 선택 필수");
		} 
		if(genderArr[0].checked) {
			alert("성별 : 남")
		} else {
			alert("성별 : 여")
		}
	}
	function checkAll() {
		if(document.fr.check_all.checked) {
			document.fr.hobby[0].checked = true;
			document.fr.hobby[1].checked = true;
			document.fr.hobby[2].checked = true;
		} else {
			document.fr.hobby[0].checked = false;
			document.fr.hobby[1].checked = false;
			document.fr.hobby[2].checked = false;
		}
	}
	function checkAll2(isChecked) {
// 		alert(isChecked);
		if(isChecked) {
			document.fr.hobby[0].checked = true;
			document.fr.hobby[1].checked = true;
			document.fr.hobby[2].checked = true;
		} else {
			document.fr.hobby[0].checked = false;
			document.fr.hobby[1].checked = false;
			document.fr.hobby[2].checked = false;
		}
	}
</script>
</head>
<body>
	<h1>test23.jsp</h1>
	<form action="test23-2.jsp" method="get" name="fr">
	취미 : 
	<input type="checkbox" name="hobby" value = "programming">프로그래밍
	<input type="checkbox" name="hobby" value = "등산" onchange="alert(this.checked)">등산
	<input type="checkbox" name="hobby" value = "요리">요리
	<input type="checkbox" name="check_all" value = "전체선택" onclick="checkAll()" >전체선택
	<input type="checkbox" name="check_all" value = "전체선택2" onclick="checkAll2(this.checked)" >전체선택2
	<input type="button" value = "취미 체크완료" onclick="printHobby()">
	<br>
	성별 : 
	<input type="radio" name="gender" value = "남">남
	<input type="radio" name="gender" value = "여">여
	<input type="button" value = "성별 선택완료" onclick="printGender()">
	<br>
	<input type="button" value = "전송">
	</form>
</body>
</html>