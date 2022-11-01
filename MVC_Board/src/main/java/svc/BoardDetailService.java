package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardDetailService {
	public BoardBean getBoard(int board_num, String work) {
		BoardBean board = null;
		
		Connection con = JdbcUtil.getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		
		// BoardDAO 클래스의 updateReadcount() 메서드 호출하여 게시물 조회수 증가 작업 수행
		// 추가사항! 실제 조회시에만 조회수 증가하도록 work 변수값이 "detail"인지 판별
		if(work.equals("detail")) {
			dao.updateReadCount(board_num);
		}
		
		// BoardDAO 클래스의 selectBoard() 메서드 호출하여 게시물 상세 정보 조회 작업 수행 후
		// 리턴되는 BoardBean 객체 전달받아 저장
		// => 파라미터 : 글번호		리턴타입 : BoardBean(board)
		board = dao.selectBoard(board_num);
		
		if(board == null) {
			JdbcUtil.rollback(con);
		} else {
			JdbcUtil.commit(con);
		}
		
		JdbcUtil.close(con);
		
		return board;
	}
}
