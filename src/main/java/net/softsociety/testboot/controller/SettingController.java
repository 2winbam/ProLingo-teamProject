package net.softsociety.testboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("settings")
public class SettingController {

	/**
	 * sign in page
	 * @return
	 */
	@GetMapping("")
	public String setting() {
		return "settingsView/setting";
	}
	
	/**
	 * sine up page
	 * @return
	 */
	@GetMapping("/account")
	public String accountsetting() {
		return "settingsView/accountSettingForm";
	}
	
	/**
	 * sine up page
	 * @return
	 */
	@GetMapping("/changepassword")
	public String changepassword() {
		return "settingsView/changePassword";
	}
}
