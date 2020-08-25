package kr.ac.kopo.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

//@Controller
public class MemberController2 {

	@Autowired
	private MemberService memberService;

	@GetMapping("/login") // @RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginForm() {
		return "/login/login";
	}

	@PostMapping("/login") // @RequestMapping(value="/login", method= RequestMethod.POST)
	public String login(MemberVO member, HttpServletRequest request) {

		MemberVO loginVO = memberService.login(member);

		// 로그인 실패
		if (loginVO == null) {
			return "redirect:login";
		}

		// 로그인 성공
		HttpSession session = request.getSession();
		session.setAttribute("loginVO", loginVO);

		return "redirect:/board";
	}

	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/";
	}

}
