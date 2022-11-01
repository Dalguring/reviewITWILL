<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login_page</title>
<style type="text/css">
#login > a {
	text-decoration: none;
}
#naverLogin {
	background-color: white;
	border-radius: 10px;
	font-size: 1.5em;
	width: 300px; height: 50px;
}
#kakaoLogin {
	background-color: white;
	border-radius: 10px;
	font-size: 1.5em;
	width: 300px; height: 50px;
}
</style>
</head>
<body>
	<div align="center"><img src="Kream_logo.JPG"></div>
	<form action="">
		<div id="login" align="center">
			<h3>이메일주소</h3><input type="text" name="id" id="id" required placeholder="예) kream@kream.co.kr"><br>
			<h3>비밀번호</h3><input type="password" name="passwd" id="passwd" required placeholder="8~20자리 영문,숫자,특수기호 포함">
		</div>
		<br>
		<div id="login" align="center">
			<input type="button" name="loginBtn" id="loginBtn" value="로그인"><br>
		</div>
		<br>
	</form>
	<div id="login" align="center">
		<a href="" target="_blanck">이메일 가입</a>  |  <a href="" target="_blanck">이메일 찾기</a>  |  <a href="" target="_blanck">비밀번호 찾기</a>
	</div>
	<br>
	<div align="center">
		<input type="button" id="naverLogin" value="네이버로 로그인">
	</div>
	<br>
	<div align="center">
		<input type="button" id="kakaoLogin" value="카카오 계정으로 로그인">
	</div>
	
</body>
</html>