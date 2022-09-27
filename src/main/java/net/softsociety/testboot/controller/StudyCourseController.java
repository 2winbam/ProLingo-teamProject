package net.softsociety.testboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.testboot.domain.ProlingoQuestionVO;
import net.softsociety.testboot.service.QuestionService;
import net.softsociety.testboot.service.QuestionServiceImpl;
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
	
	@Autowired
	QuestionService qs;
	
	/**
	 * get방식으로 lessonid를 받아서 모델에 넣어줌
	 * kim : 걍 여기서 문제 받아와서 넣어버리겠음
	 * @param lessonid
	 * @param questionindex
	 * @param model
	 * @return 컴파일 문제 풀이 페이지
	 */
	@GetMapping("javaCourse/compilerForm")
	public String compilerForm(
			@RequestParam(name="lessonid", defaultValue="0")int lessonid, 
			@RequestParam(name="questionindex", defaultValue="0")int questionindex, 
			Model model) {
		log.debug("lessonid : {}", lessonid);
		
		ArrayList<ProlingoQuestionVO> questionList = qs.selectAllQuestionsByLessonID(lessonid);		
		
		model.addAttribute("lessonid", lessonid);
		model.addAttribute("questionindex", questionindex);
		model.addAttribute("questionList", questionList);
		
		return "studyCourse/compilerForm";
	}
	 
}
