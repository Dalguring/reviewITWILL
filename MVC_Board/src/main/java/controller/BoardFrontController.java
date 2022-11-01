package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BoardDeleteProAction;
import action.BoardDetailAction;
import action.BoardListAction;
import action.BoardListAction_backup;
import action.BoardListJsonAction;
import action.BoardModifyFormAction;
import action.BoardModifyProAction;
import action.BoardReplyFormAction;
import action.BoardReplyProAction;
import action.BoardWriteProAction;
import action.BoardWriteProAction_backup;
import vo.ActionForward;

// 요청 및 응답에 대한 흐름을 제어하는 FrontController 클래스 정의
@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	
	// GET 방식 & POST 방식 요청에 대한 공통 작업을 수해하는 doProcess() 메서드 정의
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 서블릿 주소 추출
		String command = request.getServletPath();
		System.out.println("command : " + command);
		
		// 공통으로 사용할 변수 선언
		Action action = null; // XXXAction 클래스를 공통으로 관리할 Action 인터페이스 타입
		ActionForward forward = null;
		
		// 요청받은 서블릿 주소 판별을 통해 각각 다른 작업 수행
		// BoardWriteForm.bo => qna_board_write.jsp
		// BoardWritePro.bo
		// BoardList.bo => qna_board_list.jsp
		if(command.equals("/BoardWriteForm.bo")) {
			System.out.println("글쓰기 뷰페이지 이동!");
			// 포워딩 대상이 뷰페이지(*.jsp)인 경우 Dispatcher 방식으로 포워딩
			// (별다른 비즈니스 로직이 필요하지 않을 경우)
			// 현재 서블릿 주소 (= 요청 주소) 루트(http://localhost:8080/MVC_Board/BoardWriteForm.bo)
			// => 주의! webapp 폴더(루트) 내의 board 폴더에 있는 qna_board_write.jsp 페이지
//			RequestDispatcher dispatcher = request.getRequestDispatcher("board/qna_board_write.jsp");
//			dispatcher.forward(request, response);
			
			// 공통으로 포워딩 작업을 처리하기 위해 ActionForward 객체 생성
			forward = new ActionForward();
			forward.setPath("board/qna_board_write.jsp");
			forward.setRedirect(false);
			
		} else if(command.equals("/BoardWritePro.bo")) {
			System.out.println("글쓰기 비즈니스 로직!");
			// 글쓰기 비즈니스 작업 요청
			// 비즈니스 작업을 처리할 Action 클래스의 인스턴스 생성 후 execute() 메서드를 호출
			// => 파라미터 : HttpServletRequest 객체, HttpServletResponse 객체
			// => 리턴타입 : ActionForward(forward)
			// => throws에 의한 예외 위임으로 예외 처리 필요
//			BoardWriteProAction action = new BoardWriteProAction();
			// XXXAction 클래스들은 Action 인터페이스의 서브클래스이므로
			// 별도의 변수를 각각 선언하기 보다 부모 인터페이스 타입인 Action 타입 변수로
			// 업캐스팅하여 공통으로 관리가 가능하다! (호출할 메서드도 상속받은 메서드이기 때문)
			action = new BoardWriteProAction(); // 업캐스팅
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/BoardList.bo")) {
			System.out.println("글목록!");
			// 글목록 비즈니스 작업 요청
			// 비즈니스 작업을 처리할 Action 클래스의 인스턴스 생성 후 execute() 메서드를 호출
			
			action = new BoardListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/BoardDetail.bo")) {
			System.out.println("글상세정보");
			
			action = new BoardDetailAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/BoardDeleteForm.bo")) {
			forward = new ActionForward();
			forward.setPath("board/qna_board_delete.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/BoardDeletePro.bo")) {
			// 글 삭제 비즈니스 작업 요청 => BoardDeleteProAction 클래스
			System.out.println("글 삭제기능");
			
			action = new BoardDeleteProAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/BoardModifyForm.bo")) {
			
			action = new BoardModifyFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/BoardModifyPro.bo")) {
			
			action = new BoardModifyProAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/BoardReplyForm.bo")) {
			
			action = new BoardReplyFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/BoardReplyPro.bo")) {
			action = new BoardReplyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/BoardListJson.bo")) {
			action = new BoardListJsonAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// -------------------------------------------------------------------------
		// ActionForward 객체 내용에 따라 각각 다른 포워딩 작업 수행
		// 1. ActionForward 객체가 null이 아닐 경우 작업 수행
		if(forward != null) {
			// 2. AcitonForward 객체에 저장된 포워딩 방식 판별
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardFrontController - doGet()");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardFrontController - doPost()");
		doProcess(request, response);
	}
	
}
