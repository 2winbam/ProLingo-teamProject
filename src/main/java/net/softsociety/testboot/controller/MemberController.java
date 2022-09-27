package net.softsociety.testboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.domain.MemberVO;
import net.softsociety.testboot.service.MemberService;

@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	// 로그인 화면
	@GetMapping("/sign_in")
	public String sign_in() {
		log.debug("called sign_in");
		return "examples/sign_in";
	}

	// 회원가입 화면
	@GetMapping("/sign_up")
	public String sign_up() {
		log.debug("called sign_up");
		return "examples/sign_up";
	}

	/**
	 * sign in page
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		
		log.debug("called login");
		
		return "memberView/loginForm";
	}
	
	/**
	 * AJAX 로그인 체크
	 * @return
	 */
	@ResponseBody
	@PostMapping("/logincheck")
	public int logincheck(String email, String user_pw) {
		log.debug("email:{}, user_pw:{}", email, user_pw);
		
		int result = service.logincheck(email, user_pw);
		
		log.debug("result(유저 아이디)값:{}", result);
		
		return result;	
	}
	
		
	/**
	 * sine up page
	 * @return
	 */
	@GetMapping("/join")
	public String join() {
		log.debug("called join");
		return "memberView/joinForm";
	}
	
	/**
	 * sine up page 처리
	 * @return
	 */
	//백앤드 되면 활성화
	@PostMapping("/join")
	public String join(MemberVO member) {
		log.debug("전달된 값 : {}", member);
		
		service.insertMember(member);
		
		log.debug("가입 결과 :" + member);
		
		return "redirect:/";
	}
	
	/**
	 * sine up page
	 * @return
	 */
	@GetMapping("/findpassword")
	public String findpassword() {
		return "memberView/findPasswordForm";
	}
	
	/**
	 * 회원정보 수정 page 불러오기
	 * @return
	 */
	@GetMapping("/mypage")	
	public String mypage(Model model, @AuthenticationPrincipal UserDetails user) {
		log.debug("called My page");
		//로그인한 ID 읽어서 개인정보 검색
		String userid = user.getUsername();
		log.debug("로그인한 id값 : {}", userid);
		MemberVO member = service.getMemerInfo(userid); 
		// 검색한 결과를 모델에 저장하고 html로 이동
		model.addAttribute("member", member);
		return "memberView/mypage";
	}
	
	/**
	 * 회원정보 수정 page 처리
	 * @return
	 */
	 //백앤드 완성 되면 활성화
	@PostMapping("/mypage")
	public String mypage(MemberVO member, @AuthenticationPrincipal UserDetails user) {
		//수정폼에 입력한 값을 전달받음
		log.debug("수정할 정보 : {}", member);
		//로그인한 ID 읽어서 전달받은 객체에 추가
		//username이 String이라 int형으로 변환후 객체에 넣어야함.
		int userid = Integer.parseInt(user.getUsername());
		log.debug("username 값 : {}", userid);
		member.setUser_id(userid);
		//그 객체를 서비스로 전달하여 DB 수정
		service.updateMemberInfo(member);
		//메인화면으로 이동
		return "redirect:/profile";
	}
	
	/**
	 * Delete account 페이지로 이동
	 * @return
	 */
	@GetMapping("/delete_account")
	public String delete_account() {
		log.debug("called Delete_Account");
		return "memberView/delete_account";
	}
	
	/**
	 * 구글 로그인 테스트용
	 */
	@ResponseBody
	@PostMapping("/getTokenTest")
	public String getTokenTest(String token) {
		log.debug(token);
		
		return "testgood";
	}
	
	@GetMapping("/pricing")
	public String pricing(Model model) {
		String user_role = "plus";
		model.addAttribute("role", user_role);
		
		return "memberView/pricing";
	}
	
	@GetMapping("upgrade")
	public String upgrade() {
		
		return "redirect:/member/pricing";
	}
}
