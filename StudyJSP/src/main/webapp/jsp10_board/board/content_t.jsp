<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// 파라미터 중 글번호(idx)가 없을 경우(= null)
	// 자바스크립트를 사용하여 "잘못된 접근입니다!" 출력 후 메인페이지(index.jsp)로 돌아가기
	if(request.getParameter("idx") == null) {
		%>
		<script>
			alert("잘못된 접근입니다!");
			location.href = "../index.jsp";
		</script>
		<%
	}
	%>
	<h1>글 상세내용 보기</h1>
	<%
	// 글번호(idx 파라미터) 가져와서 변수에 저장
	
	// 글번호에 해당하는 레코드 조회 후 조회 성공 시 테이블을 통해 게시물 상세 정보 출력
	// => 글번호, 작성자, 제목, 내용, 작성일, 조회수
	
	%>
	<table border="1">
		<tr>
			<th width="100">글번호</th><td width="100"><!-- 글번호 표시될 공간 --></td>
			<th width="100">작성자</th><td width="150"><!-- 작성자 표시될 공간 --></td>
			<th width="100">작성일</th><td width="150"><!-- 작성일 표시될 공간 --></td>
		</tr>
		<tr>
			<th>제목</th><td colspan="3"><!-- 제목 표시될 공간 --></td>
			<th>조회수</th><td><!-- 조회수 표시될 공간 --></td>
		</tr>
		<tr>
			<th>내용</th><td colspan="5"><!-- 내용 표시될 공간 --></td>
		</tr>
	</table>
</body>
</html>












