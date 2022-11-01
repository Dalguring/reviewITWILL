<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String id = request.getParameter("id");
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/mvc_board3";
	String user = "root";
	String password = "1234";
	
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, user, password);
	
	String sql = "SELECT * FROM board";
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	ResultSet rs = pstmt.executeQuery();
	
	JSONArray boardList = new JSONArray();
	while(rs.next()) {
		JSONObject board = new JSONObject();
		board.put("num", rs.getInt("board_num"));
		board.put("subject", rs.getString("board_subject"));
		board.put("name", rs.getString("board_name"));
		board.put("date", sdf.format(rs.getDate("board_date")));
		board.put("readcount", rs.getInt("board_readcount"));
		
		boardList.add(board);
	}
%>
<%=boardList %>