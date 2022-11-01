package jsp11_javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

// study_jsp3.board 테이블의 데이터 처리 작업을 담당하는 BoardDAO 클래스 정의
public class BoardDAO {
	
	public Connection getConnection() {
		Connection con = null;
		String driver = "com.mysql.cj.jdbc.Driver"; // 드라이버 클래스
		String url = "jdbc:mysql://localhost:3306/study_jsp3"; // DB 접속 정보
		String user = "root"; // 계정명
		String password = "1234"; // 패스워드

		try {
			// 1단계. 드라이버 클래스 로드
			Class.forName(driver);

			// 2단계. DB 연결
			// => 연결 성공 시 리턴되는 Connection 타입 객체를 java.sql.Connection 타입으로 저장
			con = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패! - " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패! - " + e.getMessage());
			e.printStackTrace();
		}
		
		return con;
	}
	
	//DB 자원을 반환하기 위한 close()메서드 정의
	public void close(Connection con) {
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(PreparedStatement pstmt) {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
//	// board 테이블 글쓰기 작업(INSERT)을 수행하는 insert() 메서드 정의
//	// => 파라미터 : 게시물 정보(작성자, 패스워드, 글제목, 글내용)
//	public void insert(String name, String passwd, String subject, String content) {
//		try {
//			// board 테이블에 폼 파라미터 사용하여 글쓰기 작업 수행(INSERT)
//			// => 단, 글번호(idx)는 가장 큰 번호 + 1 값으로 새로 설정
////		    작성일(date)은 데이터베이스의 now() 함수 사용
////		    조회수(readcount)는 기본값인 0 으로 설정
//			
//			// DB 연결에 필요한 정보 문자열(4가지)을 변수에 별도로 저장
//			String driver = "com.mysql.cj.jdbc.Driver"; // 드라이버 클래스
//			String url = "jdbc:mysql://localhost:3306/study_jsp3"; // DB 접속 정보
//			String user = "root"; // 계정명
//			String password = "1234"; // 패스워드
//
//			// 1단계. 드라이버 클래스 로드
//			Class.forName(driver);
//
//			// 2단계. DB 연결
//			// => 연결 성공 시 리턴되는 Connection 타입 객체를 java.sql.Connection 타입으로 저장
//			Connection con = DriverManager.getConnection(url, user, password);
//
//			// -------------------------------------------------------------------------------------------
//			// 1) 새 글 번호 계산
//			// => board 테이블의 모든 레코드의 idx 컬럼값 중 가장 큰 값 조회(데이터베이스 max() 함수 활용)
//			int idx = 1; // 새 글 번호를 저장할 변수 선언(기본값 1)
//
//			// 3단계. SQL 구문 작성 및 전달
//			// => MySQL 의 MAX(컬럼명) 함수를 사용하면 특정 컬럼에서 가장 큰 값 조회 가능
//			String sql = "SELECT MAX(idx) FROM board";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//
//			// 4단계. SQL 구문 실행 및 결과 처리
//			ResultSet rs = pstmt.executeQuery();
//
//			// 다음 레코드가 존재할 경우 첫번째 컬럼 값(INT 타입) + 1 값을 idx 변수에 저장
//			if(rs.next()) {
//				idx = rs.getInt(1) + 1;
//			}
//			// -------------------------------------------------------------------------------------------
//			// 2) 글 등록(INSERT) 작업 수행
//			// 3단계. SQL 구문 작성 및 전달
//			// => 작성일(6번 파라미터 : now() 함수 호출), 조회수(7번 파라미터 : 기본값 0)
//			sql = "INSERT INTO board VALUES (?,?,?,?,?,now(),0)";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, idx); // 새 글 번호
//			pstmt.setString(2, name); // 작성자
//			pstmt.setString(3, passwd); // 패스워드
//			pstmt.setString(4, subject); // 제목
//			pstmt.setString(5, content); // 내용
//
//			// 4단계. SQL 구문 실행 및 결과 처리
//			// => INSERT 구문 실행 시 리턴되는 값(int 타입)을 insertCount 변수에 저장 후
////		    insertCount 가 0보다 크면 "list.jsp" 페이지로 포워딩하고
////		    아니면, 자바스크립트를 통해 "글쓰기 실패!" 출력 후 이전페이지로 돌아가기
//			int insertCount = pstmt.executeUpdate();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	// board 테이블 글쓰기 작업(INSERT)을 수행하는 insert() 메서드 정의
	// => 파라미터 : 게시물 정보 = BoardDTO 객체(board)     리턴타입 : int(insertCount) 
	public int insert(BoardDTO board) {
		int insertCount = 0; // 리턴할 데이터를 저장하는 변수 선언
			Connection con = null;
			PreparedStatement pstmt = null, pstmt2 = null;
			ResultSet rs = null;
		try {
			// board 테이블에 폼 파라미터 사용하여 글쓰기 작업 수행(INSERT)
			// => 단, 글번호(idx)는 가장 큰 번호 + 1 값으로 새로 설정
//			    작성일(date)은 데이터베이스의 now() 함수 사용
//			    조회수(readcount)는 기본값인 0 으로 설정
			
			// DB 연결에 필요한 정보 문자열(4가지)을 변수에 별도로 저장
			
			con = getConnection();
			// -------------------------------------------------------------------------------------------
			// 1) 새 글 번호 계산
			// => board 테이블의 모든 레코드의 idx 컬럼값 중 가장 큰 값 조회(데이터베이스 max() 함수 활용)
			int idx = 1; // 새 글 번호를 저장할 변수 선언(기본값 1)

			// 3단계. SQL 구문 작성 및 전달
			// => MySQL 의 MAX(컬럼명) 함수를 사용하면 특정 컬럼에서 가장 큰 값 조회 가능
			String sql = "SELECT MAX(idx) FROM board";
			pstmt = con.prepareStatement(sql);

			// 4단계. SQL 구문 실행 및 결과 처리
			rs = pstmt.executeQuery();

			// 다음 레코드가 존재할 경우 첫번째 컬럼 값(INT 타입) + 1 값을 idx 변수에 저장
			if(rs.next()) {
				idx = rs.getInt(1) + 1;
			}
			// -------------------------------------------------------------------------------------------
			// 2) 글 등록(INSERT) 작업 수행
			// 3단계. SQL 구문 작성 및 전달
			// => 작성일(6번 파라미터 : now() 함수 호출), 조회수(7번 파라미터 : 기본값 0)
			sql = "INSERT INTO board VALUES (?,?,?,?,?,now(),0)";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, idx); // 새 글 번호
			// 작성자, 패스워드, 제목, 내용은 BoardDTO 객체에 저장되어 있으므로
			// BoardDTO 객체의 Getter 메서드를 호출하여 각 데이터를 꺼내서 setXXX() 메서드에 전달
			pstmt2.setString(2, board.getName()); // 작성자
			pstmt2.setString(3, board.getPasswd()); // 패스워드
			pstmt2.setString(4, board.getSubject()); // 제목
			pstmt2.setString(5, board.getContent()); // 내용

			// 4단계. SQL 구문 실행 및 결과 처리
			// => INSERT 구문 실행 시 리턴되는 값(int 타입)을 insertCount 변수에 저장 후 리턴
			insertCount = pstmt2.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - insert() : " + e.getMessage());
			e.printStackTrace();
		} finally {
//			try {
//				rs.close();
//				pstmt.close();
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			close(rs);
			close(pstmt);
			close(pstmt2);
			close(con);
		}
		
		// INSERT 구문 실행 결과를 리턴받아 저장한 변수 insertCount 값을 리턴
		return insertCount;
	} // insert() 메서드 끝
	
	
	// 글삭제 작업을 수행하는 delete() 메서드 정의
	public int delete(BoardDTO board) {
		
		int deleteCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();

			// 3단계. SQL 구문 작성 및 전달
			// => 1) 번호(idx)와 패스워드(passwd)가 모두 일치하는 게시물 삭제(DELETE) - 사용할 방법
			// => 2) 번호(idx)가 일치하는 레코드를 검색(SELECT)하여 
//		       존재할 경우 패스워드(passwd)를 검사하여 일치하면 삭제(DELETE)
			String sql = "DELETE FROM board WHERE idx=? AND passwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board.getIdx());
			pstmt.setString(2, board.getPasswd());

			// 4단계. SQL 구문 실행 및 결과 처리
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - delete()");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return deleteCount;
		
	}
	
	public ArrayList select() {
		ArrayList boardList = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM board ORDER BY idx ASC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			boardList = new ArrayList();
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setPasswd(rs.getString("passwd"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setDate(rs.getDate("date"));
				board.setReadcount(rs.getInt("readcount"));
//				boardList = new ArrayList();
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return boardList;
	}
	
	public BoardDTO selectContent(int idx) {
		BoardDTO board = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 0단계. DB 연결에 필요한 문자열 4개 저장
		
		try {
			con = getConnection();
			// 3단계
			String sql = "SELECT * FROM board WHERE idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			// 4단계
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardDTO();
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setPasswd(rs.getString("passwd"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setDate(rs.getDate("date"));
				board.setReadcount(rs.getInt("readcount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		//1개 게시물 정보가 저장된 BoardDTO 객체 리턴
		return board;
	}
	
	public void updateReadcount(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			// 3단계
			String sql = "UPDATE board SET readcount = readcount+1 WHERE idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			//4단계
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
	}
	
	
} // BoardDAO 클래스 끝













