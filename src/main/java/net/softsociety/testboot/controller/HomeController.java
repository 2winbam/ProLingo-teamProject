package net.softsociety.testboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import net.softsociety.testboot.domain.DBTestVO;
import net.softsociety.testboot.service.DBTestService;

@Controller
public class HomeController {

	@Autowired
	DBTestService service;
	
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
	
	@GetMapping("dbtest")
	public String dbtest(int tid, String tname) {
		
		DBTestVO vo = new DBTestVO(tid, tname);
		
		int result = service.insertTest(vo);
		
		return "redirect:blankpage";
	}
	
}
