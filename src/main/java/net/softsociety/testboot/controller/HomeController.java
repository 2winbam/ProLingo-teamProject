package net.softsociety.testboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.domain.DBTestVO;
import net.softsociety.testboot.domain.MemberVO;
import net.softsociety.testboot.service.DBTestService;
import net.softsociety.testboot.service.MemberService;

@Controller
@Slf4j
public class HomeController {

	@Autowired
	DBTestService service;
	
	@Autowired
	MemberService ms;
	
	@GetMapping({"","/"})
	public String home() {
		return "home";
	}
	
	@GetMapping("blankpage")
	public String blankpage() {
		return "blankpage";
	}
	
	@GetMapping("error")
	public String errorpage() {
		return "errorpage";
	}
	
	@GetMapping("loginsuccess")
	public String loginsuccess(HttpSession session, @AuthenticationPrincipal UserDetails user) {
		log.debug("로긴함");
		
		MemberVO member = ms.getMemerInfo(user.getUsername());
		
		log.debug(member.getUser_name());
		
		session.setAttribute("noticecount", member.getAge());
		session.setAttribute("nickname", member.getUser_name());
		
		return "redirect:/study";
	}
	
	/**
	 * 임시로
	 * @return rank page
	 */
	@GetMapping("rank")
	public String rank() {
		return "rank";
	}
	
	@GetMapping("dbtest")
	public String dbtest(int tid, String tname) {
		
		DBTestVO vo = new DBTestVO(tid, tname);
		
		int result = service.insertTest(vo);
		
		return "redirect:blankpage";
	}  
}
