package net.softsociety.testboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.domain.MemberVO;
import net.softsociety.testboot.service.MemberService;

@Controller
@Slf4j
public class RankController {

	@Autowired
	MemberService service;

	/**
	 * 
	 * @return rank page
	 */
	@GetMapping("rank")
	public String rank(Model model) {

		ArrayList<MemberVO> allUsers = service.selectAllUsers();

		ArrayList<MemberVO> topTenUsers = new ArrayList<>();

		for (int p = 0; p < 10; p++) {
			topTenUsers.add(allUsers.get(p));
		}

		model.addAttribute("userlist", topTenUsers);

		return "rank";
	}
}
