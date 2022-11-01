package test8_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	
	// board 테이블 글쓰기 작업(INSERT)을 수행하는 insert() 메서드 정의
	// => 파라미터 : 게시물 정보 = BoardDTO 객체(board)     리턴타입 : int(insertCount) 
	public int insert(BoardDTO board) {
		
		int insertCount = 0; // 리턴할 데이터를 저장하는 변수 선언
			Connection con = null;
			PreparedStatement pstmt = null, pstmt2 = null;
			ResultSet rs = null;
		try {
			
			con = JdbcUtil.getConnection();
			int idx = 1; // 새 글 번호를 저장할 변수 선언(기본값 1)

			String sql = "SELECT MAX(idx) FROM board";
			pstmt = con.prepareStatement(sql);

			// 4단계. SQL 구문 실행 및 결과 처리
			rs = pstmt.executeQuery();

			// 다음 레코드가 존재할 경우 첫번째 컬럼 값(INT 타입) + 1 값을 idx 변수에 저장
			if(rs.next()) {
				idx = rs.getInt(1) + 1;
			}
			sql = "INSERT INTO board VALUES (?,?,?,?,?,now(),0)";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, idx); // 새 글 번호
			pstmt2.setString(2, board.getName()); // 작성자
			pstmt2.setString(3, board.getPasswd()); // 패스워드
			pstmt2.setString(4, board.getSubject()); // 제목
			pstmt2.setString(5, board.getContent()); // 내용

			insertCount = pstmt2.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - insert() : " + e.getMessage());
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);
			JdbcUtil.close(con);
		}
		return insertCount;
	} // insert() 메서드 끝
	
	public List<BoardDTO> select() {
		List<BoardDTO> boardList = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM board ORDER BY idx ASC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boardList = new ArrayList<BoardDTO>();
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setPasswd(rs.getString("passwd"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setDate(rs.getDate("date"));
				board.setReadcount(rs.getInt("readcount"));
				
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		
		return boardList;
	}
} // BoardDAO 클래스 끝













