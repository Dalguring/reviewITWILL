package test8_board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test8List")
public class Test8ListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test8ListServlet - doGet()");
		
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> boardList = dao.select();
		
		// 글목록 페이지로 글목록이 저장된 List 객체 전달을 위해 request 객체에 List 객체 저장
		request.setAttribute("boardList", boardList);
		
		// test8_board 폴더의 list.jsp 페이지로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("test8_board/list.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
