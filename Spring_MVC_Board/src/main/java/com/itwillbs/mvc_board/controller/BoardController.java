package com.itwillbs.mvc_board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.mvc_board.service.BoardService;
import com.itwillbs.mvc_board.vo.BoardVO;
import com.itwillbs.mvc_board.vo.PageInfo;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	@GetMapping(value = "/BoardWriteForm.bo")
	public String write() {
		return "board/qna_board_write";
	}
	
//	@PostMapping(value = "/BoardWritePro.bo")
//	public String writePro(@ModelAttribute BoardVO board, Model model) {
////		board.setBoard_num(service.getMaxNum()+1);
//		int insertCount = service.registBoard(board);
//		
//		if(insertCount > 0) {
//			return "redirect:/BoardList.bo";
//		} else {
//			model.addAttribute("msg", "글 쓰기 실패!");
//			return "member/fail_back";
//		}
//	}
	// 파일업로드 기능 추가
	@PostMapping(value = "/BoardWritePro.bo")
	public String writePro(@ModelAttribute BoardVO board, Model model) {
		System.out.println(board.getBoard_file());
//		board.setBoard_num(service.getMaxNum()+1);
//		int insertCount = service.registBoard(board);
		int insertCount = 0;
		
		if(insertCount > 0) {
			return "redirect:/BoardList.bo";
		} else {
			model.addAttribute("msg", "글 쓰기 실패!");
			return "member/fail_back";
		}
	}
	
//	// "BoardList.bo" 서블릿 요청에 대해 글 목록 조회
//	// => 파라미터 : 현재 페이지번호(pageNum) => 단 기본값을 1로 설정
//	//				 데이터 저장할 Model 객체(model)
//	// => List<BoardVO> 객체 저장한 후 board/qna_board_list.jsp 페이지로 포워딩(Dispatch)
//	@GetMapping(value = "BoardList.bo")
//	public String list(@RequestParam(defaultValue = "1") int pageNum, Model model) {
//		// 페이징 처리를 위한 계산 작업
//		int listLimit = 10;
//		int pageListLimit = 10;
//		
//		// 조회 시작 게시물 번호(행 번호) 계산
//		int startRow = (pageNum - 1) * listLimit;
//		
//		// Service 객체의 getBoardList() 메서드를 호출하여 게시물 목록 조회
//		// => 파라미터 : 시작행번호, 페이지 당 목록 갯수
//		// => 리턴타입 : List<BoardVO> (boardList)
//		List<BoardVO> boardList = service.getBoardList(startRow, listLimit);
//		
//		// ----------------------------------------------------------------------
//		int listCount = service.getBoardListCount();
//		
//		// 페이지 계산 작업 수행
//		// 전체 페이지 수 계산
//		// Math 클래스의 ceil() 메서드를 활용하여 소수점 올림 처리를 통해 전체 페이지 수 계산
//		// => listCount / listLimit 를 실수 연산으로 수행하여 소수점까지 계산하고
//		//	  Math.ceil() 메서드를 통해 올림 처리 후 결과값을 정수로 변환
//		int maxPage = (int)Math.ceil((double)listCount / listLimit);
//		
//		int startPage = (pageNum - 1) / pageListLimit * pageListLimit + 1;
//		
//		// 5. 끝 페이지 번호 계산
//		// => 시작 페이지 + 페이지목록갯수 - 1
//		int endPage = startPage + pageListLimit - 1;
//		
//		// 6. 만약, 끝 페이지 번호(endPage)가 최대 페이지 번호(maxPage)보다 클 경우 
//		//    끝 페이지 번호를 최대 페이지 번호로 교체
//		if(endPage > maxPage) {
//			endPage = maxPage;
//		}
//		
//		// 페이징 처리 정보를 저장하는 PageInfo 클래스 인스턴스 생성 및 데이터 저장
//		PageInfo pageInfo = new PageInfo(pageNum, listLimit, listCount, pageListLimit, maxPage, startPage, endPage);
////		System.out.println(pageInfo);
//		// ---------------------------------------------------------------------------
//		// getBoardList() -> selectBoardList()
////		List<BoardVO> boardList = service.getBoardList();
//		// 기시물 목록(boardList)과 페이징 처리 정보(pageInfo) 를 Model 객체에 저장
//		model.addAttribute("boardList", boardList);
//		model.addAttribute("pageInfo", pageInfo);
//		
//		return "board/qna_board_list";
//	}
	
	// ================== 검색 기능 추가 구현
	
	// "BoardList.bo" 서블릿 요청에 대해 글 목록 조회
	// => 파라미터 : 검색타입(searchType) => 기본값 널스트링
	//				 검색어(keyword) => 기본값 널스트링
	//				 현재 페이지번호(pageNum) => 단 기본값을 1로 설정
	//				 데이터 저장할 Model 객체(model)
	// => List<BoardVO> 객체 저장한 후 board/qna_board_list.jsp 페이지로 포워딩(Dispatch)
	@GetMapping(value = "BoardList.bo")
	public String list(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "") String searchType,
			@RequestParam(defaultValue = "") String keyword,
			Model model) {
//		System.out.println("searchType : " + searchType);
//		System.out.println("keyword : " + keyword);
		// 페이징 처리를 위한 계산 작업
		int listLimit = 10;
		int pageListLimit = 10;
		
		// 조회 시작 게시물 번호(행 번호) 계산
		int startRow = (pageNum - 1) * listLimit;
		
		// Service 객체의 getBoardList() 메서드를 호출하여 게시물 목록 조회
		// => 파라미터 : 시작행번호, 페이지 당 목록 갯수
		// => 리턴타입 : List<BoardVO> (boardList)
		List<BoardVO> boardList = service.getBoardList(startRow, listLimit, searchType, keyword);
		
		// ----------------------------------------------------------------------
		int listCount = service.getBoardListCount(searchType, keyword);
		
		// 페이지 계산 작업 수행
		// 전체 페이지 수 계산
		// Math 클래스의 ceil() 메서드를 활용하여 소수점 올림 처리를 통해 전체 페이지 수 계산
		// => listCount / listLimit 를 실수 연산으로 수행하여 소수점까지 계산하고
		//	  Math.ceil() 메서드를 통해 올림 처리 후 결과값을 정수로 변환
		int maxPage = (int)Math.ceil((double)listCount / listLimit);
		
		int startPage = (pageNum - 1) / pageListLimit * pageListLimit + 1;
		
		// 5. 끝 페이지 번호 계산
		// => 시작 페이지 + 페이지목록갯수 - 1
		int endPage = startPage + pageListLimit - 1;
		
		// 6. 만약, 끝 페이지 번호(endPage)가 최대 페이지 번호(maxPage)보다 클 경우 
		//    끝 페이지 번호를 최대 페이지 번호로 교체
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 페이징 처리 정보를 저장하는 PageInfo 클래스 인스턴스 생성 및 데이터 저장
		PageInfo pageInfo = new PageInfo(pageNum, listLimit, listCount, pageListLimit, maxPage, startPage, endPage);
//			System.out.println(pageInfo);
		// ---------------------------------------------------------------------------
		// getBoardList() -> selectBoardList()
//			List<BoardVO> boardList = service.getBoardList();
		// 기시물 목록(boardList)과 페이징 처리 정보(pageInfo) 를 Model 객체에 저장
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageInfo", pageInfo);
		
		return "board/qna_board_list";
	}
	
	// "BoardDetail.bo" 서블릿 요청에 대한 글 상세내용 조회 작업 수행
	// => detail() -> Service increaseReadcount() -> updateReadcount() 로 조회수 증가
	// => detail() -> Service getBoard() -> selectBoard() 로 조회
	// => board/qna_board_view.jsp
	@GetMapping(value = "BoardDetail.bo")
	public String detail(String board_num, Model model) { // int board_num도 상관없음
		// service 객체의 increaseReadcount() 메서드 호출하여 게시물 조회 증가 
		service.increaseReadcount(board_num);
		
		// service 객체의 getBoard() 메서드를 호출하여 게시물 상세 정보 조회
		// => 파라미터 : 글번호,	리턴타입 : BoardVO(board)
		BoardVO board = service.getBoard(board_num);
		
		// Model 객체에 BoardVO 객체 추가
		model.addAttribute("board", board);
		
		return "board/qna_board_view";
	}
	
	@GetMapping(value = "BoardDeleteForm.bo")
	public String delete() {
		return "board/qna_board_delete";
	}
	
	// "BoardDeletePro.bo" 서블릿 요청에 대한 글 삭제
	@PostMapping(value = "/BoardDeletePro.bo")
	public String deletePro(@ModelAttribute BoardVO board, @RequestParam int pageNum, Model model) {
		// Serivce - removeboard() 메서드 호출하여 삭제 작업 요청
		// => 파라미터 : BoardVO 객체,	리턴타입 : int(deleteCount)
		int deleteCount = service.removeboard(board);
		
		// 삭제 실패 시 "패스워드 틀림!" 메세지 저장 후 fail_back.jsp 페이지로 포워딩
		// 아니면, BoardList.bo 서블릿 요청(페이지번호 전달)
		if(deleteCount <= 0) {
			model.addAttribute("msg", "패스워드 틀림!");
			return "member/fail_back";
		} else {
			return "redirect:/BoardList.bo?pageNum=" + pageNum;
		}
	}
	
	@GetMapping(value = "/BoardModifyForm.bo")
	public String modify(String board_num, Model model) {
		BoardVO board = service.getModifyForm(board_num);
		
		model.addAttribute("board", board);
		return "board/qna_board_modify";
	}
	
	@PostMapping(value = "/BoardModifyPro.bo")
	public String modifyPro(BoardVO board, int pageNum, Model model) {
		int updateCount = service.modifyBoard(board);
		if(updateCount > 0) {
			return "redirect:/BoardDetail.bo?board_num=" + board.getBoard_num() + "&pageNum=" + pageNum;
		} else {
			model.addAttribute("msg", "패스워드 틀림!");
			return "member/fail_back";
		}
	}
	
	@GetMapping(value = "BoardReplyForm.bo")
	public String reply(@RequestParam String board_num, Model model) {
		BoardVO board = service.getBoard(board_num);
		model.addAttribute("board", board);
		return "board/qna_board_reply";
	}
	
	// "BoardReplyPro.bo" 서블릿 요청에 대한 답글 작성 요청 - POST
	@PostMapping(value = "BoardReplyPro.bo")
	public String replyPro(@ModelAttribute BoardVO board, int pageNum, Model model) {
		// Service - increaseBoardReSeq() 메서드 호출하여 순서번호 조정요청
		// => 파라미터 : BoardVO 객체,		리턴타입 : void
		service.increaseBoardReSeq(board);
		
		// Service - registReplyBoard() 메서드 호출
		// => 파라미터 : BoardVO 객체,		리턴타입 : int(insertCount)
		int insertCount = service.registReplyBoard(board);
		
		if(insertCount > 0) {
			return "redirect:/BoardList.bo?pageNum=" + pageNum;
		} else {
			model.addAttribute("msg", "답글 등록 실패!");
			return "member/fail_back";
		}
	}
	
	
	
	
	
	
}
