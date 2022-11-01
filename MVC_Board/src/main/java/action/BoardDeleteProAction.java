package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cipher.MyMessageDigest;
import db.JdbcUtil;
import svc.BoardDeleteProService;
import vo.ActionForward;

public class BoardDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String pageNum = request.getParameter("pageNum");
		// ------------------------- 패스워드 단방향 암호화 기능 추가 ------------------------
		// MyMessageDigest 객체의 hashing() 메서드를 호출하여 "SHA-256" 알고리즘으로 패스워드 해싱
		MyMessageDigest md = new MyMessageDigest("SHA-256");
		// ----------------------------------------------------------------------------
		String board_pass = md.hashing(request.getParameter("board_pass"));
//		System.out.println(board_num + ", " + pageNum + ", " + board_pass);
		BoardDeleteProService service = new BoardDeleteProService();
		boolean isBoardWriter = service.isBoardWriter(board_num, board_pass);
		
		if(!isBoardWriter) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 권한이 없습니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			System.out.println("삭제 가능!");
			boolean isDeleteSuccess = service.removeBoard(board_num);
			// 삭제 요청 결과 판별
			// => 성공 시 서블릿 주소 요청 시 페이지번호를 파라미터로 함께 전달
			System.out.println(isDeleteSuccess);
			
			if(!isDeleteSuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("BoardList.bo?pageNum="+pageNum);
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}
