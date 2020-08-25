package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardService {

	/**
	 * 전체게시글 조회
	 * @return
	 */
	List<BoardVO> selectAllBoard();
	
	/**
	 * 상세게시글조회
	 */
	BoardVO selectBoardByNo(int no);
	
	/**
	 * 게시글 작성
	 * @param board
	 */
	void insertBoard(BoardVO board);
}
