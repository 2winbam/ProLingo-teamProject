package net.softsociety.testboot.controller;

import javax.servlet.http.HttpSession;

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

	/**
	 * sign in page
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String login() {

		log.debug("called login");

		return "memberView/loginForm";
	}

	/**
	 * AJAX 로그인 체크
	 * 
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
	 * 
	 * @return
	 */
	@GetMapping("/join")
	public String join() {
		log.debug("called join");
		return "memberView/joinForm";
	}

	/**
	 * sine up page 처리
	 * 
	 * @return
	 */
	@PostMapping("/join")
	public String join(MemberVO member) {

		// log.debug("전달된 값 : {}", member);

		service.insertMember(member);

		log.debug("가입 결과 :" + member);

		return "redirect:/";
	}

	/**
	 * sine up page
	 * 
	 * @return
	 */
	@GetMapping("/findpassword")
	public String findpassword() {
		return "memberView/findPasswordForm";
	}

	/**
	 * 회원정보 수정 page 불러오기
	 * 
	 * @return
	 */
	@GetMapping("/mypage")
	public String mypage(Model model, @AuthenticationPrincipal UserDetails user) {
		log.debug("called My page");
		// 로그인한 ID 읽어서 개인정보 검색
		String userid = user.getUsername();
		log.debug("로그인한 id값 : {}", userid);
		MemberVO member = service.getMemerInfo(userid);
		// 검색한 결과를 모델에 저장하고 html로 이동
		model.addAttribute("member", member);
		return "memberView/mypage";
	}

	/**
	 * 회원정보 수정 page 처리
	 * 
	 * @return
	 */
	@PostMapping("/mypage")
	public String mypage(MemberVO member, @AuthenticationPrincipal UserDetails user) {
		// 수정폼에 입력한 값을 전달받음
		log.debug("수정할 정보 : {}", member);
		// 로그인한 ID 읽어서 전달받은 객체에 추가
		// username이 String이라 int형으로 변환후 객체에 넣어야함.
		int userid = Integer.parseInt(user.getUsername());
		log.debug("username 값 : {}", userid);
		member.setUser_id(userid);
		// 그 객체를 서비스로 전달하여 DB 수정
		service.updateMemberInfo(member);
		// 메인화면으로 이동
		return "redirect:/profile";
	}

	/**
	 * Delete account 페이지로 이동
	 * 
	 * @return
	 */
	@GetMapping("/delete_account")
	public String delete_account(Model model, @AuthenticationPrincipal UserDetails user) {
		log.debug("called Delete_Account");
		// 로그인한 ID 읽어서 개인정보 검색
		String userid = user.getUsername();
		log.debug("로그인한 id값 : {}", userid);
		MemberVO member = service.getMemerInfo(userid);
		log.debug("불러온 회원 정보 : {}", member);
		// 검색한 결과를 모델에 저장하고 html로 이동
		model.addAttribute("member", member);
		return "memberView/delete_account";
	}

	/**
	 * Delete account 계정 삭제 처리
	 * 
	 * @return
	 */
	@PostMapping("/delete_account")
	public String delete_account(String user_pw, @AuthenticationPrincipal UserDetails user) {
		// page에서 입력 값을 전달 받음
		log.debug("전달받은 값 : {}", user_pw);
		// 로그인한 ID 읽어서 변수명 선언
		String userid = user.getUsername();
		// MemberVO member = service.getMemerInfo(userid);
		// log.debug("db에서 전달된 값 : {}", member);

		// 로그인id와 입력받은 비번을 서비스로 전달
		int result = service.deleteAccont(userid, user_pw);

		if (result == 1) {
			log.debug("삭제성공");
			return "redirect:/";
		} else {
			log.debug("삭제실패");
			return "redirect:/profile";
		}
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
	public String pricing(Model model, @AuthenticationPrincipal UserDetails user) {
		String user_role = "plus";
		model.addAttribute("role", user_role);

		MemberVO member = service.getMemerInfo(user.getUsername());
		model.addAttribute("member", member);

		return "memberView/pricing";
	}

	@GetMapping("/upgrade")
	public String upgrade() {

		return "redirect:/member/pricing";
	}

	@GetMapping("loginsuccess")
	public String loginsuccess(HttpSession session, @AuthenticationPrincipal UserDetails user) {
		// log.debug("로긴함");

		MemberVO member = service.getMemerInfo(user.getUsername());
		String photourl = "";
		// log.debug(member.getUser_name());
		if (member.getPhoto() == null) {
			photourl = "/prolingo/img/avatars/basicprofilePhoto.png";
		} else {
			photourl = "/prolingo/img/avatars/" + member.getPhoto();
		}

		session.setAttribute("noticecount", member.getAge());
		session.setAttribute("nickname", member.getNickname());
		session.setAttribute("username", member.getUser_name());
		session.setAttribute("userexp", member.getUser_exp());
		session.setAttribute("continueday", member.getContinueday());
		session.setAttribute("usermoney", member.getMoney());
		session.setAttribute("userphoto", photourl);

		session.setAttribute("userinfo", member);

		return "redirect:/study";
	}
}