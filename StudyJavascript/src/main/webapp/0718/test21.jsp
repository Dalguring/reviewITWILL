<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function func1() {
// 		alert(document.img1.src);
// 		alert(document.images[0].src);
		var imgInfo = "src : " + document.img1.src + "\nwidth : " + document.img1.width + "\nheight : " + document.img1.height 
					 		   + "\nborder : " + document.img1.border;
		alert(imgInfo);
	}
	function func2() {
		document.images[0].width = "300";
		document.images[0].height = "300";
		document.images[0].border = "10";
		document.images[0].src = "2.jpg";
	}
	function changeImg(imgName) {
		document.img3.src = imgName;
	}

</script>
</head>
<body>
	<h1>test21.jsp</h1>
	<img src = "1.jpg" width="200" height="200" border="2" name="img1" title="펭수" alt="펭수없음"><br>
	<input type="button" value="이미지속성정보출력" onclick="func1()">
	<input type="button" value="이미지속성정보변경" onclick="func2()"><br>
	<img src = "3.jpg" width="200" height="200" border="2" name="img3" onmouseover="changeImg('4.jpg')" onmouseout="document.img3.src = '5.jpg'">
</body>
</html>