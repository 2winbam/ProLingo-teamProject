package net.softsociety.testboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("study")
public class StudyCourseController {

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
	public String JavaIntroduction() {
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
