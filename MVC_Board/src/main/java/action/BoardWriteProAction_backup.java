package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

// 서블릿 요청에 대한 제어작업을 보조할 Action 클래스
public class BoardWriteProAction_backup {
	// execute() 메서드를 정의하여 요청에 대한 처리 준비작업 수행(ex. 파라미터 데이터 가져오기 등)
	// => BoardFrontController로부터 메서드 호출 시 
	//    HttpServletRequest, HttpServletResponse 객체를 전달받아야함
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardWriteProAction");
		String board_name = request.getParameter("board_name");
		System.out.println(board_name);
		
		// 글쓰기 작업 --------------------------------
		
		// 글쓰기 작업 완료 후 BoardList.bo 서블릿 주소 요청하기 위해 return문 사용
		// => 이 때, 서블릿 주소(BoardList.bo)와 함께 포워딩 방식도 Redirect로 지정해야하므로
		//	  reutrn 문에 직접 리턴은 불가능하며
		//	  이 정보를 관리해줄 ActionForward 클래스의 인스턴스를 통해 정보 저장 후
		//	  ActionForward 객체를 리턴해야함
		
		ActionForward forward = new ActionForward();
		forward.setPath("BoardList.bo");
		forward.setRedirect(true);
		
		return forward;
		
	}
	
	
	
}
