package net.softsociety.testboot.controller;

import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {

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
		//log.debug("called login");
		
		return "memberView/loginForm";
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
	 * sine up page
	 * @return
	 */
	@GetMapping("/findpassword")
	public String findpassword() {
		return "memberView/findPasswordForm";
	}
	
	@ResponseBody
	@PostMapping("/getTokenTest")
	public String getTokenTest(String token) {
		log.debug(token);
		
		return "testgood";
	}
}
