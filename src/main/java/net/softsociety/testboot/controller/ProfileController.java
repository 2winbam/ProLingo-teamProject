package net.softsociety.testboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("profile")
public class ProfileController {

	/**
	 * 
	 * @return profile page
	 */
	@GetMapping("")
	public String profile() {
		log.debug("called profile");
		return "profile";
	}
	/**
	 * 업적 달성 페이지
	 * @return
	 */
	@GetMapping("/achievements")
	public String achievements() {
		log.debug("called achievements");
		return "profile/achievements";
	}
	/**
	 * 타임라인 페이지
	 * @return
	 */
	@GetMapping("/timelineTest")
	public String timelineTest() {
		log.debug("called timelineTest");
		return "profile/timelineTest";
	}
	
	
}
