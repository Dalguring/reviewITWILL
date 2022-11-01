package test8_board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test8WritePro")
public class Test8WriteProServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test8WriteProServlet - doPost()");
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println("이름 : " + name);
		System.out.println("비밀번호 : " + passwd);
		System.out.println("제목 : " + subject);
		System.out.println("내용 : " + content);
		
		BoardDTO board = new BoardDTO();
		board.setName(name);
		board.setPasswd(passwd);
		board.setSubject(subject);
		board.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		int insertCount = dao.insert(board);
		
		if(insertCount > 0) {
			response.sendRedirect("Test8List");
		} else {
			System.out.println("글쓰기 실패!");
		}
		
	}

}
