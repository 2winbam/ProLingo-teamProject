package net.softsociety.testboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.service.StudyCourseService;

@Slf4j
@Controller
@RequestMapping("study")
public class StudyCourseController {
	
	@Autowired
	StudyCourseService service;
	
	@GetMapping("javaCourse")
	public String JavaCourse() {
		return"studyCourse/javaCourse";
	}
	
	/**
	 * 
	 * @return 코스 선택 페이지
	 */
	@GetMapping("")
	public String selectCourse() {
		return "studyCourse/selectCourse";
	}
	
	/**
	 * 
	 * @return 자바 입문
	 */
	@GetMapping("javaCourse/introduction")
	public String JavaIntroduction(Model model) {
		
		//ArrayList<testLesson> chapterLisst = 
		
		
		return "studyCourse/java_introduction";
	}
	
	/**
	 * 
	 * @return 자바 초급
	 */
	@GetMapping("javaCourse/beginner")
	public String JavaBeginner() {
		return "studyCourse/java_beginner";
	}
	
	/**
	 * 
	 * @return 컴파일러 문제 폼
	 */
	@GetMapping("javaCourse/compilerForm")
	public String compilerForm() {
		return "studyCourse/compilerForm";
	}
	 
}
