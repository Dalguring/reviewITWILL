package action;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import cipher.MyMessageDigest;
import svc.BoardModifyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String realFolder = ""; 			// 업로드 실제 경로(톰캣)
		String uploadFolder = "upload"; 	// 업로드 가상 경로(이클립스)
		int fileSize = 1024 * 1024 * 10; 	// 파일 업로드 최대 크기(= 10MB)
		
		realFolder = request.getServletContext().getRealPath(uploadFolder);
		MultipartRequest multi = new MultipartRequest(
			request, // 1) 실제 요청 정보가 포함된 request 객체
			realFolder, // 2) 실제 업로드 되는 폴더 경로(서버마다 달라질 수 있음 - 탐색 필요)
			fileSize, // 3) 업로드 파일 최대 크기(작은 단위부터 계산하여 저장 - Byte 단위)
			"UTF-8", // 4) 한글 파일명을 처리하기 위한 인코딩 방식
			new DefaultFileRenamePolicy() // 5) 중복 파일명에 대한 기본 처리 담당 객체 생성(파일명 뒤에 숫자 붙임)
		);
		
		int board_num = Integer.parseInt(multi.getParameter("board_num"));
		String pageNum = multi.getParameter("pageNum");
		// ------------------------- 패스워드 단방향 암호화 기능 추가 ------------------------
		// MyMessageDigest 객체의 hashing() 메서드를 호출하여 "SHA-256" 알고리즘으로 패스워드 해싱
		MyMessageDigest md = new MyMessageDigest("SHA-256");
		String board_pass = md.hashing(multi.getParameter("board_pass"));
		// ----------------------------------------------------------------------------
		
		BoardModifyProService service = new BoardModifyProService();
		boolean isBoardWriter = service.isBoardWriter(board_num, board_pass);
		
		if(!isBoardWriter) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 권한이 없습니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			BoardBean board = new BoardBean();
			board.setBoard_num(board_num);
			board.setBoard_name(multi.getParameter("board_name"));
			board.setBoard_pass(board_pass);
			board.setBoard_subject(multi.getParameter("board_subject"));
			board.setBoard_content(multi.getParameter("board_content"));
			String fileElement = multi.getFileNames().nextElement().toString();
			board.setBoard_file(multi.getOriginalFileName(fileElement)); // 원본 파일명
			board.setBoard_real_file(multi.getFilesystemName(fileElement)); // 실제 업로드 된 파일명
			
			boolean isModifySuccess = service.modifyBoard(board);
			
			if(!isModifySuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('글 수정 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				if(board.getBoard_file() != null) {
					// java.io.File 객체 생성
					// => 파라미터 : 업로드 폴더명, 삭제할 실제 파일명
					File f = new File(realFolder, multi.getParameter("board_real_file"));
					
					// 생성한 파일 객체에서 지정된 파일이 존재할 경우에만 삭제
					if(f.exists()) {
						f.delete();
					}
				}
				
				forward = new ActionForward();
				forward.setPath("BoardDetail.bo?board_num="+board.getBoard_num()+"&pageNum="+pageNum);
				forward.setRedirect(true);
			}
			
		}
		
		return forward;
	}

}
