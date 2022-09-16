package net.softsociety.testboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String index() {
		log.debug("called index");
		return "index";
	}
	
	@GetMapping("/header")
	public String header() {
		log.debug("call header");
		return "header";
	}
	
	@GetMapping("/compilerForm")
	public String compilerForm() {
		log.debug("call compilerForm");
		return "compilerForm";
	}
	
}
