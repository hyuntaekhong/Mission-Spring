package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;

@Repository // 데이터베이스를 access해서 CRUD 해주는 DAO 클래스들의 객체 생성 어노테이션
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession; // spring-mvc.xml에 빈객체로 만들어져 있음

	@Override
	public List<BoardVO> selectAll() {

		List<BoardVO> boardList = sqlSession.selectList("board.dao.BoardDAO.selectAll");

		return boardList;
	}

	@Override
	public BoardVO selectByNo(int no) {

		BoardVO board = sqlSession.selectOne("board.dao.BoardDAO.selectByNo", no); // boardMapper.xml과 연결
		return board;
	}
	

	@Override
	public void insert(BoardVO board) {
		sqlSession.insert("board.dao.BoardDAO.insert", board);
		System.out.println("check in daoimpl : " + board);
	}

}
