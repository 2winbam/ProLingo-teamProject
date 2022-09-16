package net.softsociety.testboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {
	
	//로그인 화면
	@GetMapping("/sign_in")
	public String sign_in() {
		log.debug("called sign_in");
		return "sign_in";
	}
	
	//회원가입 화면
	@GetMapping("/sign_up")
	public String sign_up() {
		log.debug("called sign_up");
		return "sign_up";
	}
}
