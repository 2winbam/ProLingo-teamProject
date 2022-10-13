package net.softsociety.testboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.softsociety.testboot.domain.DBTestVO;
import net.softsociety.testboot.domain.MemberVO;
import net.softsociety.testboot.service.DBTestService;

@Controller
public class HomeController {

	@Autowired
	DBTestService service;

	@GetMapping({ "", "/" })
	public String home() {
		return "home";
	}
}
