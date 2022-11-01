package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.JdbcUtil;
import vo.BoardBean;

public class BoardDAO {
	// ------------------- 싱글톤 디자인 패턴을 활용한 BoardDAO 인스턴스 작업 ---------------------------
	// 1. 외부에서 인스턴스 생성이 불가능하도록 생성자를 private 접근제한자로 지정
	// 2. 자신의 클래스 내에서 직접 인스턴스를 생성하여 변수에 저장
	//	  => 인스턴스 생성 없이 클래스가 메모리에 로딩될 때 함께 로딩되도록 static변수로 선언
	//	  => 외부에서 함부로 접근하여 값을 변경할 수 없도록 private 접근제한자로 지정
	// 3. 생성된 인스턴스를 외부로 리턴하는 Getter 메서드 정의
    //	  => 인스턴스 생성 없이 클래스가 메모리에 로딩될 때 함께 로딩되도록 static 메서드로 선언
	//	     (static 변수인 instance에 접근하기 위해 static 메서드로 정의)
	// 	  => 누구나 접근할 수 있도록 public 접근제한자로 지정
	private BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	// --------------------------------------------------------------------------------------------------
	// 데이터베이스 접근을 위해 Connection 객체를 Service 클래스로부터 전달받기 위한
	// 멤버변수 및 Setter 메서드 정의
	private Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}
	// --------------------------------------------------------------------------------------------------
	// Service 클래스로부터 BoardBean 객체를 전달받아 글쓰기 작업 수행 및 결과 리턴
	
	public int insertBoard(BoardBean board) {
		System.out.println("BoardDAO - insertBoard()");
		int insertCount = 0;
		
		// 데이터베이스 작업에 필요한 변수 선언
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			// board 테이블의 게시물 최대 번호를 조회하여 새 글번호 결정(+1) 
			int num = 1;
			String sql = "SELECT MAX(board_num) FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1) + 1;
				System.out.println("새 글 번호 : " + num);
			}
			
			// 전달받은 데이터(BoardBean 객체)를 사용하여 INSERT 작업 수행
			// => 참조글번호(board_re_ref)는 새 글 번호와 동일한 번호로 지정
			// => 들여쓰기레벨(board_re_lev)과 순서번호(board_re_seq)는 0으로 지정
			sql = "INSERT INTO board VALUES (?,?,?,?,?,?,?,?,?,?,?,now())";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, num);
			pstmt2.setString(2, board.getBoard_name());
			pstmt2.setString(3, board.getBoard_pass());
			pstmt2.setString(4, board.getBoard_subject());
			pstmt2.setString(5, board.getBoard_content());
			pstmt2.setString(6, board.getBoard_file());
			pstmt2.setString(7, board.getBoard_real_file());
			pstmt2.setInt(8, num);
			pstmt2.setInt(9, 0);
			pstmt2.setInt(10, 0);
			pstmt2.setInt(11, 0);
			
			insertCount = pstmt2.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 발생! - insertBoard()");
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);
			// 주의! DAO 객체 내에서 Connection 객체 반환하지 않도록 주의할 것
		}
		return insertCount; // BoardWriteProService 로 리턴
	}
	
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 조회 결과가 있을 경우 첫번째 컬럼 데이터를 저장
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return listCount;
	}
	
	// 게시물 목록 작업을 수행하는 selectBoardList() 메서드 정의
	public List<BoardBean> selectBoardList(int pageNum, int listLimit) {
		List<BoardBean> boardList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 조회 시작 레코드(게시물) 행 번호 계산
		int startRow = (pageNum - 1) * 10;
		
		// 게시물 조회 구문 작성
		// => 정렬 : 참조글번호(board_re_ref) 기준 내림차순, 순서번호(board_re_seq) 기준 오름차순
		// => 조회 시작 레코드 행번호(startRow)부터 listLimit 갯수(10) 만큼만 조회
		
		try {
			String sql = "SELECT * FROM board ORDER BY board_re_ref DESC, board_re_seq ASC LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, listLimit);
			rs = pstmt.executeQuery();
			// 읽어올 게시물이 존재할 경우
			// BoardBean 객체 생성하여 1개 레코드(게시물)를 저장 후 
			// BoardBean 객체를 List<BoardBean> 객체에 추가 반복
			// => 단, 반복문 위에서 먼저 List<BoardBean>객체 생성 필요
			boardList = new ArrayList<BoardBean>();
			while(rs.next()) {
				BoardBean board = new BoardBean();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
//				board.setBoard_pass(rs.getString("board_pass"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_real_file(rs.getString("board_real_fil"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getDate("board_date"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - selectBoardList()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return boardList;
	}
	
	// 게시물 조회수 증가작업
	public void updateReadCount(int board_num) {
		PreparedStatement pstmt = null;
		
		// 글번호에 해당하는 레코드의 조회수(board_readcount)값 1증가하는 UPDATE 구문 작성
		try {
			String sql = "UPDATE board SET board_readcount=board_readcount+1 WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
	}
	
	// 게시물 상세 정보 조회
	public BoardBean selectBoard(int board_num) {
		BoardBean board = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM board WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardBean();
				
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
//				board.setBoard_pass(rs.getString("board_pass"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_real_file(rs.getString("board_real_fil"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getDate("board_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return board;
		
	}
	
	public boolean isBoardWriter(int board_num, String board_pass) {
		boolean isBoardWriter = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM board WHERE board_num=? AND board_pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.setString(2, board_pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				isBoardWriter = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return isBoardWriter;
	}
	
	public int deleteBoard(int board_num) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM board WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			deleteCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return deleteCount;
	}
	
	public int updateBoard(BoardBean board) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		// 작성자, 제목, 내용, 원본파일, 실제파일명 변경
		// => 단 수정할 파일이 null일 경우 파일 관련 컬럼은 수정 대상에서 제외
			if(board.getBoard_file() == null) {
				try {
				String sql="UPDATE board SET board_name=?, board_subject=?, board_content=? WHERE board_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getBoard_name());
				pstmt.setString(2, board.getBoard_subject());
				pstmt.setString(3, board.getBoard_content());
				pstmt.setInt(4, board.getBoard_num());
				
				updateCount = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JdbcUtil.close(pstmt);
				}
				
				return updateCount;
			
			} else {
				try {
					String sql="UPDATE board SET board_name=?, board_subject=?, board_content=?, board_file=?, board_real_fil=? WHERE board_num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, board.getBoard_name());
					pstmt.setString(2, board.getBoard_subject());
					pstmt.setString(3, board.getBoard_content());
					pstmt.setString(4, board.getBoard_file());
					pstmt.setString(5, board.getBoard_real_file());
					pstmt.setInt(6, board.getBoard_num());
					
					updateCount = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JdbcUtil.close(pstmt);
				}
			
				return updateCount;
			}
	}

	public int insertReplyBoard(BoardBean board) {
		int insertCount = 0;
		
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			int num = 1;
			String sql = "SELECT MAX(board_num) FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1) + 1;
//				System.out.println("새 글 번호 : " + num);
			}
			
			// ----------------------------------------------------------------------------
			int re_ref = board.getBoard_re_ref();
			int re_lev = board.getBoard_re_lev();
			int re_seq = board.getBoard_re_seq();
			
			// 기존 답글들에 대한 순서번호 증가 작업(UPDATE 구문 사용)
			// => 원본글의 참조글번호(board_re_ref)와 같은 레코드들 중에서
			//	  원본글의 순서번호보다 큰 게시물들의 순서번호를 +1씩 처리
			sql = "UPDATE board SET board_re_seq=board_re_seq+1 "
					+ "WHERE board_re_ref=? AND board_re_seq>?";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, re_ref);
			pstmt2.setInt(2, re_seq);
			pstmt2.executeUpdate();
			pstmt2.close();
			
			// 새 답글의 들여쓰기 레벨과 순서번호를 원본글의 번호 + 1로 증가처리
			re_lev++;
			re_seq++;
			
			// 답글 INSERT 작업 수행
			sql = "INSERT INTO board VALUES (?,?,?,?,?,?,?,?,?,?,?,now())";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, num);
			pstmt2.setString(2, board.getBoard_name());
			pstmt2.setString(3, board.getBoard_pass());
			pstmt2.setString(4, board.getBoard_subject());
			pstmt2.setString(5, board.getBoard_content());
			pstmt2.setString(6, board.getBoard_file());
			pstmt2.setString(7, board.getBoard_real_file());
			pstmt2.setInt(8, re_ref);
			pstmt2.setInt(9, re_lev);
			pstmt2.setInt(10, re_seq);
			pstmt2.setInt(11, 0);
			
			insertCount = pstmt2.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 구문 오류 발생! - insertBoard()");
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);
		}
		
		return insertCount;
	}
	
	
	
	
}
