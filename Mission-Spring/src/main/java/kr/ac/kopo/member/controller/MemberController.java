package kr.ac.kopo.member.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;


@SessionAttributes({"loginVO"})	//loginVO 객체는 session 공유영역에 등록하라.(배열이 들어올 수 있다)
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
//	@RequestMapping(value="/login", method = RequestMethod.GET)
	
	@GetMapping("/login")
	public String loginForm() {
		return "/login/login";
	}
	
//	@RequestMapping(value="/login", method= RequestMethod.POST)
	
//	public String login(@RequestParam("id") String id, @RequestParam("password") String password) {
	@PostMapping("/login") //RequestMapping 대체
	public ModelAndView login(MemberVO member, HttpSession session) {	//form 태그의 name 속성값과 memberVO의 멤버변수와 동일하면 자동으로 매핑
						
		MemberVO loginVO = memberService.login(member);
		ModelAndView mav = new ModelAndView();
		
		// 로그인 실패
		if(loginVO == null) {
			mav.setViewName("redirect:/login");

		// 로그인 성공
		} else { 
		
			// preHandle 거쳤는지 여부 확인
			String dest = (String)session.getAttribute("dest");
			
			if(dest == null) {
				//메인 페이지
				mav.setViewName("redirect:/");

			} else {
				mav.setViewName("redirect:" + dest );
				session.removeAttribute(dest);
			}
			mav.addObject ("loginVO", loginVO);
		}
		
		return mav;
	}
	
	@RequestMapping("/logout")
	public String logout(SessionStatus status) {	//@SessionAttributes()와 짝을 이뤄 사용한다!!
		System.out.println(status.isComplete());
		
		status.setComplete();   //세션등록이 끝나지 않으면 완료되지 않는다고 생각한다. 따라서 setComplete 메소드로 완료시켜준다.
		
		return "redirect:/";
	}
}
