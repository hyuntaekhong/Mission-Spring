package kr.ac.kopo.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.member.vo.MemberVO;
import oracle.jdbc.proxy.annotation.Post;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService; // service <-> DAO <-> DB

	/**
	 * 게시판 목록 컨트롤러
	 * 
	 * @return
	 */

	@RequestMapping("/board")
	public ModelAndView list() {

		List<BoardVO> boardList = boardService.selectAllBoard();

		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("boardList", boardList);

		return mav;

	}

	/**
	 * 게시판 상세조회 컨트롤러 2 http://localhost:9999/Mission-Spring/board/12
	 * 
	 * @param boardNo
	 * @return
	 */
	@RequestMapping("/board/{no}")
	public ModelAndView detail(@PathVariable("no") int boardNo) { // @PathVariable 경로에 들어가는 파라미터 값

		BoardVO board = boardService.selectBoardByNo(boardNo);

		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board", board);
		return mav;
	}

	/**
	 * 게시판 상세조회 컨트롤러 1 http://localhost:9999/Mission-Spring/board/detail?no=12 url로
	 * detail?no=12 담아 날아간다.
	 * 
	 * @param boardNo
	 * @return
	 */
	/*
	 * @RequestMapping("/board/detail") public ModelAndView
	 * detail(@RequestParam("no") int boardNo) {
	 * 
	 * BoardVO boardDetail = boardService.selectBoardByNo(boardNo);
	 * 
	 * ModelAndView mav = new ModelAndView("board/detail"); mav.addObject("board",
	 * boardDetail); return mav; }
	 */

	@GetMapping("/board/write")
	public String writeForm(Model model, HttpSession session) { // void일 경우 GetMapping의 주소를 리턴한다.

		BoardVO board = new BoardVO();
		board.setTitle("hello");

		model.addAttribute("boardVO", new BoardVO()); // modelAndView : 객체 + 포워드 리다이렉트 주소 / model : 공유영역 등록할 객체만 가지고 있음

		return "/board/write";
	}

	@PostMapping("/board/write")
	public String write(@Valid BoardVO boardVO, BindingResult result) {	//BindingResult : 바인딩된 결과값을 가지는 객체

		System.out.println(boardVO);

		if (result.hasErrors()) {
			System.out.println("오류발생...");
			return "/board/write";
		}

		return "redirect:/board";
	}

}
