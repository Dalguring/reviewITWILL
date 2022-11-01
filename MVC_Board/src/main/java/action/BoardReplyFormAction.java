package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String pageNum = request.getParameter("pageNum");
		
		BoardDetailService service = new BoardDetailService();
		BoardBean board = service.getBoard(board_num, "reply");
		
		request.setAttribute("board", board);
		
		forward = new ActionForward();
		forward.setPath("board/qna_board_reply.jsp?board_num=" + board_num + "&pageNum=" + pageNum);
		forward.setRedirect(false);
		
		return forward;
	}

}
