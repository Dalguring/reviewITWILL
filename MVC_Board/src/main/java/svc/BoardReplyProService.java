package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardReplyProService {

	public boolean registReplyBoard(BoardBean board) {
		boolean isReplySuccess = false;
		
		Connection con = JdbcUtil.getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		
		int insertCount = dao.insertReplyBoard(board);
		
		// 작업 처리 결과에 따른 트렌젝션 처리
		if(insertCount > 0) {	// 작업 성공했을 경우
			JdbcUtil.commit(con); // Service 클래스가 관리하는 Connection 객체 필요
			isReplySuccess = true;
		} else {				// 작업 실패했을 경우
			JdbcUtil.rollback(con);
		}
		
		JdbcUtil.close(con);
		
		return isReplySuccess;
	}
	
}
