package com.itwillbs.mvc_board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.mvc_board.cipher.MyMessageDigest;
import com.itwillbs.mvc_board.service.MemberService;
import com.itwillbs.mvc_board.vo.MemberVO;

@Controller
public class MemberController {
	// Service 객체를 직접 생성하지 않고, 자동 주입 기능을 위한 어노테이션 사용
	// => @Inject(자바-플랫폼 공용) 또는 @Autowired(스프링 전용) 어노테이션 사용 가능
	// => 어노테이션 지정 후 자동 주입으로 객체를 생성하면 저장될 클래스 타입 변수 선언
	// => 단, 해당 클래스는 반드시 어노테이션을 통해 역할이 지정되어야 한다!
	@Autowired
	private MemberService service;
	
	// "/MemberJoinForm.me" 요청에 대해 member/member_join_form.jsp 페이지 실행
	@GetMapping(value = "/MemberJoinForm.me")
	public String join() {
		return "member/member_join_form";
	}
	
	// "/MemberJoinPro.me" 요청에 대해 비즈니스 로직 처리할 joinPro() 메서드 정의 - POST
	// => 파라미터 : 회원 가입 정보(MemberVO), Model 객체
	@PostMapping(value = "/MemberJoinPro.me")
	public String joinPro(@ModelAttribute MemberVO member, Model model) {
		// 파라미터로 전달받은 패스워드를 암호화 후 덮어쓰기
		MyMessageDigest md = new MyMessageDigest("SHA-256");
		member.setPasswd(md.hashing(member.getPasswd()));
		
		// MemberService 객체의 joinMember() 메서드 호출
		// => 파라미터 : MemberVO객체	리턴타입 : int(insertCount)
//		MemberService service = new MemberService();
		// @AutoWired 어노테이션을 통해 MemberService 객체를 별도로 생성하지 않아도 
		//자동 주입(= 의존 주입)되므로 객체를 직접 생성하지 않고 사용 가능
		int insertCount = service.joinMember(member);
		
		if(insertCount > 0) { // 가입 성공
			System.out.println("가입성공");
			return "redirect:/";
		} else { // 가입 실패
			// 가입 실패 메세지 출력 후 "member/fail_back.jsp"페이지로 이동(Dispatch)
			// => Model 객체를 통해 "msg" 속성명으로 "가입 실패!" 메세지 전달
			model.addAttribute("msg", "가입실패!");
			return "member/fail_back";
		}
	}
	
	@GetMapping(value = "/MemberLoginForm.me")
	public String login() {
		return "member/member_login_form";
	}
	
	@PostMapping(value = "/MemberLoginPro.me")
	public String loginPro(@ModelAttribute MemberVO member, Model model, HttpSession session) {
		MyMessageDigest md = new MyMessageDigest("SHA-256");
		member.setPasswd(md.hashing(member.getPasswd()));
		
		// MemberService - loginMember() 호출
		// => 파라미터 : MemberVO 객체, 리턴타입 : MemberVO(memberResult)
		MemberVO memberResult = service.loginMember(member);
		
		if(memberResult == null) {
			model.addAttribute("msg", "로그인 실패!");
			return "member/fail_back";
		} else {
//			System.out.println("로그인 성공!");
			// HttpSession 객체에 세션 아이디 저장 후 메인페이지로 이동(Redirect 방식)
			session.setAttribute("sId", memberResult.getId());
			return "redirect:/";
		}
	}
	
	@GetMapping(value = "/MemberLogout.me")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// MemberInfo.me 요청에 대한 회원정보 조회 처리 => GET
	// => 파라미터 : 아이디
	// => 조회 결과(회원 1명의 정보)를 저장하는 MemberVO 객체를 저장할 Model 타입 변수 필요
	//	  전달받은 아이디와 비교를 통해 권한 확인에 사용될 세션 객체
	@GetMapping(value = "/MemberInfo.me")
	public String getMemberInfo(@RequestParam String id,@ModelAttribute Model model, HttpSession session) {
		String sId = (String)session.getAttribute("sId");
		if(id == null || sId == null 
					  || !id.equals(sId)
					  || !sId.equals("admin")) {
			model.addAttribute("msg", "잘못된 접근입니다!");
			return "member/fail_back";
		} else {
			MemberVO member = service.getMemberInfo(id);
			System.out.println(member);
			model.addAttribute("member", member);
			return "member/member_info";
		}
		
	}
	
	
	
	
	
	
	
	
	
}



