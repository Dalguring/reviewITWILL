package com.itwillbs.mvc_board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.mvc_board.mapper.BoardMapper;
import com.itwillbs.mvc_board.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardMapper mapper;
	
//	public int getMaxNum() {
//		return mapper.selectMaxNum();
//	}
	
	public int registBoard(BoardVO board) {
		return mapper.insertBoard(board);
	}

//	public List<BoardVO> getBoardList() {
//		return mapper.selectBoardList();
//	}

	public int getBoardListCount(String searchType, String keyword) {
		return mapper.selectBoardListCount(searchType, keyword);
	}
	
	// 게시물 목록 조회
	public List<BoardVO> getBoardList(int startRow, int listLimit, String searchType, String keyword) {
		return mapper.selectBoardList(startRow, listLimit, searchType, keyword);
	}
	
	// 게시물 상세 정보 조회
	public BoardVO getBoard(String board_num) {
		return mapper.selectBoard(board_num);
	}
	
	// 조회수 증가 작업
	public void increaseReadcount(String board_num) {
		mapper.updateReadcount(board_num);
	}

	public int removeboard(BoardVO board) {
		return mapper.deleteBoard(board);
	}

	public BoardVO getModifyForm(String board_num) {
		return mapper.selectBoard(board_num);
	}

	public int modifyBoard(BoardVO board) {
		return mapper.updateBoard(board);
	}
	

}
