package net.softsociety.testboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"","/"})
	public String home() {
		return "home";
	}
	
	@GetMapping("blankpage")
	public String blankpage() {
		return "blankpage";
	}
	
	/**
	 * 임시로
	 * @return rank page
	 */
	@GetMapping("rank")
	public String rank() {
		return "rank";
	}
	
}
