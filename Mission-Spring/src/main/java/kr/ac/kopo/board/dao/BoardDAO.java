package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardDAO {
	/**
	 * 전체게시글 조회서비스
	 */
	public List<BoardVO> selectAll();
	
	/**
	 * 새글 등록 서비스
	 */
	public void insert(BoardVO board);
	
	/**
	 * 게시글 상세 조회서비스
	 * @param no 게시물번호
	 */
	public BoardVO selectByNo(int no);
	
	
}
