package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String pageNum = request.getParameter("pageNum");
		
		BoardDetailService service = new BoardDetailService();
		BoardBean board = service.getBoard(board_num, "modify");
		
		request.setAttribute("board", board);
		
		forward = new ActionForward();
		forward.setPath("board/qna_board_modify.jsp?pageNum="+pageNum);
		forward.setRedirect(false);
		
		return forward;
	}

}
