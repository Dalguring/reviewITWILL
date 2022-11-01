<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
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
	function checkId() {
		var spancheckIdResult = document.getElementById("Id");
		if(Id.length >= 4 && Id.length <= 8) {
			location.href = "check_id.jsp"
			document.getElementById("checkIdResult").innerHTML = "중복확인완료";
		} else {
			alert("4 ~ 8글자만 사용가능합니다")
		}
	}
	function checkPw(passwd) {
		var spanPwResult = document.getElementById("checkPasswdResult");
		if(passwd.length >= 8 && passwd.length <= 16) {
			spanPwResult.innerHTML = "사용 가능한 패스워드";
			spanPwResult.style.color = "BLUE";
		} else {
			spanPwResult.innerHTML = "사용 불가능한 패스워드";
			spanPwResult.style.color = "RED";
		}
	}
	function checkPw2(passwd2) {
		var spanPwResult2 = document.getElementById("checkPasswd2Result");
		if(passwd2== document.fr.passwd.value) {
			spanPwResult2.innerHTML = "비밀번호 일치";
			spanPwResult2.style.color = "BLUE";
		} else {
			spanPwResult.innerHTML = "비밀번호 불일치";
			spanPwResult.style.color = "RED";
	}


</script>
</head>
<body>
	<h1>final_exam의 회원가입 페이지</h1>
	<h1>회원가입</h1>
	<form name="fr">
	<table border="1">
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="text" name="ID" id = "Id" placeholder="4 ~ 8글자 사이 입력">
				<input type="button" value="ID중복확인" onclick="checkId()">
				<span id="checkIdResult"></span>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" id="passwd" placeholder="8 ~ 16글자 사이 입력" onkeyup = "checkPw(this.value)">
				<span id="checkPasswdResult"></span>
			</td>
		</tr>
		<tr>
			<td>비밀번호확인</td>
			<td><input type="password" name="passwd" onkeyup="checkPw2(this.value)">
				<span id="checkPasswd2Result"></span>
			</td>
		</tr>
		<tr>
			<td>주민번호</td>
			<td><input type="text" name="idnum"> - <input type="password" name="idnum"></td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td><input type="text" name="e-address"> @ <input type="text" name="e-address"> 
				<select name = "address">
				<option>직접입력</option>
				<option>naver.com</option>
				<option>nate.com</option>
				<option>gmail.com</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>직업</td>
			<td>
				<select name = "job">
				<option>항목을 선택하세요</option>
				<option>개발자</option>
				<option>DB엔지니어</option>
				<option>관리자</option>
				<option>기타</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td><input type="radio" name="gender" value = "남">남 <input type="radio" name="gender" value = "여">여</td>
		</tr>
		<tr>
			<td>취미</td>
			<td><input type="checkbox" name="hobby" value = "trip">여행
			    <input type="checkbox" name="hobby" value = "book">독서
			    <input type="checkbox" name="hobby" value = "game">게임
			    <input type="checkbox" name="check_all" value = "checkall" onclick="checkAll()">전체선택
			</td>
		</tr>
		<tr>
			<td>가입동기</td>
			<td><textarea name = "text" cols= 45 rows = 15></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align = "center">
			<input type = "submit" name = "sub" value = "가입">
			<input type = "reset" name = "res" value = "초기화">
			<input type = "button" name = "back" value = "돌아가기">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>