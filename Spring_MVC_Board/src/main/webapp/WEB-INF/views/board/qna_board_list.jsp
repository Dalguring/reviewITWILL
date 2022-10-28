<%@page import="com.itwillbs.mvc_board.vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<link href="<%=request.getContextPath() %>/resources/css/top.css" rel="stylesheet" type="text/css">
<style type="text/css">
	#listForm {
		width: 1024px;
		max-height: 610px;
		margin: auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		margin: auto;
		width: 1024px;
		table-layout: fixed;
	}
	
	table td {
		text-align: center;
		text-overflow: ellipsis;
		overflow: hidden;
		white-space: nowrap;
	}
	
	#tr_top {
		background: orange;
		text-align: center;
	}
	.td_left {
		text-align: left;
		padding-left: 10px;
	}
	
	#pageList {
		margin: auto;
		width: 1024px;
		text-align: center;
	}
	
	#emptyArea {
		margin: auto;
		width: 1024px;
		text-align: center;
	}
	
	#buttonArea {
		margin: auto;
		width: 1024px;
		text-align: right;
	}
	
	a {
		text-decoration: none;
	}
	
</style>
<script src="js/jquery-3.6.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#btn2').click(function(){
			$.ajax({
				url:'BoardListJson.bo',
				dataType:'json',
				success:function(result){
					$.each(result,function(index,items){
						$('#table2').append('<tr id="tr_top"><td width="100px">'+items.board_num+'</td><td>'+items.board_subject+'</td><td width="150px">'+items.board_name+'</td><td width="150px">'+items.board_date+'</td><td width="100px">'+items.board_readcount+'</td></tr>');
					});
				}
			});
		});
	});
</script>

</head>
<body>
	<header>
		<!-- Login, Join 링크 표시 영역(inc/top.jsp 페이지 삽입) -->
		<jsp:include page="<%=request.getContextPath() %>/WEB-INF/inc/top.jsp"></jsp:include>
	</header>
	<!-- 게시판 리스트 -->
	<section id="listForm">
		<h2>게시판 글 목록</h2>
		<table>
			<tr id="tr_top">
				<td width="100px">번호</td>
				<td>제목</td>
				<td width="150px">작성자</td>
				<td width="150px">날짜</td>
				<td width="100px">조회수</td>
			</tr>
			<c:forEach var="board" items="${boardList }">
			<tr>
				<td width="100px">${board.board_num }</td>
				<td class="td_left">
					<%-- ======================= 답글 관련 목록 처리 추가 ======================= --%>
					<%-- board_re_lev 값이 크면 해당 값만큼 공백(&nbsp) 추가 --%>
					<c:if test="${board.board_re_lev gt 0}">
						<%-- c:forEach 문을 통해 0부터 board_re_lev값까지 1씩 증가하면서 공백 추가 --%>
						<c:forEach var="i" begin="1" end="${board.board_re_lev }">
							&nbsp;
						</c:forEach>
						<img src="images/re.gif"> <!-- 현재 이 페이지는 매핑된 주소로 표시되기에 주소표시줄 기준으로 경로 설정해야함 -->
					</c:if>
					<%-- ========================================================================= --%>
					<a href="BoardDetail.bo?board_num=${board.board_num}&pageNum=${pageInfo.pageNum}">
						${board.board_subject }</a>
				</td>
				<td width="150px">${board.board_name }</td>
				<td width="150px">${board.board_date }</td>
				<td width="100px">${board.board_readcount }</td>
			</tr>
			</c:forEach>
		</table>
	</section>
	<section id="buttonArea">
		<input type="button" value="글쓰기" onclick="location.href='BoardWriteForm.bo'" />
	</section>
	<section id="pageList">
			<!-- 현재 페이지번호가 시작 페이지번호보다 클 때 현재 페이지번호 - 1 값으로 페이지 이동 -->
<%-- 			<c:choose> --%>
<%-- 				<c:when test="${pageInfo.pageNum > pageInfo.startPage }"> --%>
<%-- 					<input type="button" value="이전" onclick="location.href='BoardList.bo?pageNum=${pageInfo.pageNum - 1}'"> --%>
<%-- 				</c:when> --%>
<%-- 				<c:otherwise> --%>
<!-- 					<input type="button" value="이전"> -->
<%-- 				</c:otherwise> --%>
<%-- 			</c:choose> --%>
			<%PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo"); %>
			<input type="button" value="이전" <%if(pageInfo.getPageNum() > pageInfo.getStartPage()) {%>onclick="location.href='BoardList.bo?pageNum=${pageInfo.pageNum - 1}'"><%} %>
			<!-- 시작페이지(startPage)부터 끝페이지(endPage)까지 페이지 번호 표시 -->
			&nbsp;
			<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
				<c:choose>
					<c:when test="${i eq pageInfo.pageNum }">${i }</c:when>
					<c:otherwise><a href="BoardList.bo?pageNum=${i }">${i }</a></c:otherwise>
				</c:choose>
			&nbsp;
			</c:forEach>
			<!-- 현재 페이지번호가 끝 페이지번호보다 작을 때 현재 페이지번호 + 1 값으로 페이지 이동 -->
			<input type="button" value="다음" <%if(pageInfo.getPageNum() < pageInfo.getMaxPage()) {%>onclick="location.href='BoardList.bo?pageNum=${pageInfo.pageNum + 1}'"><%} %>
	</section>
</body>
</html>
